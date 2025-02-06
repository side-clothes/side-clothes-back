package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.common.util.UserUtil;
import com.a1.a1.dto.request.auth.*;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.auth.FindIdPostResponseDto;
import com.a1.a1.dto.response.auth.ResetPasswordPostResponseDto;
import com.a1.a1.dto.response.auth.SignInPostResponseDto;
import com.a1.a1.dto.response.auth.SignUpPostResponseDto;
import com.a1.a1.entity.RecommendEntity;
import com.a1.a1.entity.UserEntity;
import com.a1.a1.provider.JwtProvider;
import com.a1.a1.repository.RecommendRepository;
import com.a1.a1.repository.UserRepository;
import com.a1.a1.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtProvider tokenProvider;
    private final MailServiceImpl mailService;
    private final UserRepository userRepository;
    private final RecommendRepository recommendRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseDto<SignUpPostResponseDto> signUp(SignUpRequestDto dto) {
        String userId = dto.getUserId();
        String userEmail = dto.getUserEmail();
        String userPasswordCheck = dto.getUserPasswordCheck();
        String recommendedUserId = dto.getRecommendedUserId();
        String userPassword = dto.getUserPassword();

        SignUpPostResponseDto data = null;

        if (userId == null || userId.isEmpty())
            return ResponseDto.setFailed(ResponseMessage.INVALID_USER_ID);
        if (userRepository.existsById(userId))
            return ResponseDto.setFailed(ResponseMessage.EXIST_DATA);

        if (userEmail == null || userEmail.isEmpty() || !EmailValidator.getInstance().isValid(userEmail))
            return ResponseDto.setFailed(ResponseMessage.INVALID_EMAIL);
        if (userRepository.existsByUserEmail(userEmail))
            return ResponseDto.setFailed(ResponseMessage.EXIST_DATA);

        if (userPassword == null || userPassword.isEmpty() || userPasswordCheck == null || userPasswordCheck.isEmpty())
            return ResponseDto.setFailed(ResponseMessage.INVALID_PASSWORD);
        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD);
        if (userPassword.length() < 8 || !userPassword.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{10,}$"))
            return ResponseDto.setFailed(ResponseMessage.WEAK_PASSWORD);


        RecommendEntity recommendEntity = new RecommendEntity();

        if(recommendedUserId != null){
            if(userRepository.existsById(recommendedUserId)){

                try {
                    recommendEntity.setRecommendedUserId(recommendedUserId);
                    recommendEntity.setRecommendingUserId(userId);
                    recommendRepository.save(recommendEntity);

                } catch (Exception exception) {
                    exception.printStackTrace();
                    return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
                }
            } else {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);

            }
        } else {
            recommendedUserId = "";
        }



        String encodedPassword = passwordEncoder.encode(userPassword);
        dto.setUserPassword(encodedPassword);

        UserEntity userEntity = new UserEntity(dto);

        try {

            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        data = new SignUpPostResponseDto(userEntity, recommendEntity);
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<FindIdPostResponseDto> findId(FindIdRequestDto dto) {

        FindIdPostResponseDto data = null;

        String userEmail = dto.getUserEmail();
        String userName = dto.getUserName();

        try {

            UserEntity userEntity = userRepository.findByUserEmailAndUserName(userEmail, userName);

            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);

            data = new FindIdPostResponseDto(userEntity.getUserId());

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<ResetPasswordPostResponseDto> resetPassword(ResetPasswordPostRequestDto dto) {

        ResetPasswordPostResponseDto data = null;

        String userId = dto.getUserId();
        String password = dto.getUserPassword();
        String passwordCheck = dto.getUserPasswordCheck();

        try {

            if (!password.equals(passwordCheck)) return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD);

            UserEntity userEntity = userRepository.findByUserId(userId);

            String encodedPassword = passwordEncoder.encode(password);
            userEntity.setUserPassword(encodedPassword);
            userRepository.save(userEntity);

            data = new ResetPasswordPostResponseDto(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<SignInPostResponseDto> signIn(SignInRequestDto dto) {

        SignInPostResponseDto data = null;
        UserEntity userEntity = null;

        String userId = dto.getUserId();
        String userPassword = dto.getUserPassword();

        try {

            userEntity = userRepository.findByUserId(userId);

            boolean matched = passwordEncoder.matches(userPassword, userEntity.getUserPassword());
            if (!matched)
                return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD);

            userEntity.setUserPassword(ResponseMessage.NULL);

            String token = tokenProvider.generateToken(userId);
            int exprTime = tokenProvider.getExpiration();

            data = new SignInPostResponseDto(token, exprTime, userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    // 임시 비밀번호 전송
    public ResponseDto<Boolean> sendPasswordEmail(SendPasswordEmailRequestDto dto) {

        String userEmail = dto.getUserEmail();

        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEmail == null) return ResponseDto.setFailed(null);

            String temporaryPassword = UserUtil.getTemporaryPassword();
            String encodedPassword = passwordEncoder.encode(temporaryPassword);

            userEntity.setUserPassword(encodedPassword);
            userRepository.save(userEntity);

            boolean successedSendMail = mailService.sendPasswordEmail(temporaryPassword, userEmail);
            if (!successedSendMail) return ResponseDto.setFailed("");

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(null);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, true);
    }

}