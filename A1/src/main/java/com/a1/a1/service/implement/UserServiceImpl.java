package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.request.user.UserPatchRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.user.UserDeleteResponseDto;
import com.a1.a1.dto.response.user.UserGetResponseDto;
import com.a1.a1.dto.response.user.UserPatchResponseDto;
import com.a1.a1.entity.UserEntity;
import com.a1.a1.repository.UserRepository;
import com.a1.a1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public ResponseDto<UserGetResponseDto> getUser(String userId) {

        UserGetResponseDto data = null;
        UserEntity user = null;
        try {

            Optional<UserEntity> userEntity = userRepository.findByUserId(userId);
            if(userEntity.isPresent()) {
                user = userEntity.get();
            } else {
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }

            if (user != null)
                user.setUserPassword(ResponseMessage.NULL);

            data = new UserGetResponseDto(user);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<UserPatchResponseDto> patchUser(String userId, UserPatchRequestDto dto) {

        UserPatchResponseDto data = null;
        UserEntity user = null;

        try {

            Optional<UserEntity> userEntity = userRepository.findByUserId(userId);
            if(userEntity.isPresent()) {
                user = userEntity.get();
            } else {
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }
            if (user == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            user.setPatchUser(dto);
            userRepository.save(user);

            data = new UserPatchResponseDto(user);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess("Sucess", data);

    }

    public ResponseDto<UserDeleteResponseDto> deleteUser(String userId, String userEmail) {

        UserDeleteResponseDto data = null;
        UserEntity user = null;
        try {

            if (!userRepository.existsByUserIdAndUserEmail(userId, userEmail))
                return ResponseDto.setFailed("UserId Or UserEmail Does Not Exist");

            Optional<UserEntity> userEntity = userRepository.findByUserId(userId);
            if(userEntity.isPresent()) {
                user = userEntity.get();
            } else {
                return ResponseDto.setFailed("UserId Or UserEmail Does Not Exist");
            }
            userRepository.delete(user);

            data = new UserDeleteResponseDto();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed("Failed");
        }

        return ResponseDto.setSuccess("Success", data);

    }
}