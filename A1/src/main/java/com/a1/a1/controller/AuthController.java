package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.auth.*;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.auth.FindIdPostResponseDto;
import com.a1.a1.dto.response.auth.ResetPasswordPostResponseDto;
import com.a1.a1.dto.response.auth.SignInPostResponseDto;
import com.a1.a1.dto.response.auth.SignUpPostResponseDto;
import com.a1.a1.service.implement.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.AUTH)
@RequiredArgsConstructor
public class AuthController {


    private final AuthServiceImpl authService;

    private static final String POST_SIGN_UP = "/signUp";
    private static final String POST_SIGN_IN = "/signIn";

    private static final String POST_FIND_ID = "/findId";

    private static final String POST_RESET_PASSWORD = "/resetPassword";
    private static final String POST_SEND_PASSWORD_EMAIL = "/sendPassword";

    @PostMapping(POST_SIGN_UP)
    public ResponseEntity<ResponseDto<SignUpPostResponseDto>> signUp(@Valid @RequestBody SignUpRequestDto requestBody) {
        ResponseDto<SignUpPostResponseDto> response = authService.signUp(requestBody);
        HttpStatus status = response.isResult() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PostMapping(POST_SIGN_IN)
    public ResponseEntity<ResponseDto<SignInPostResponseDto>> signIn(@Valid @RequestBody SignInRequestDto requestBody) {
        ResponseDto<SignInPostResponseDto> response = authService.signIn(requestBody);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PostMapping(POST_FIND_ID)
    public ResponseDto<FindIdPostResponseDto> findId(@Valid @RequestBody FindIdRequestDto requestBody) {
        ResponseDto<FindIdPostResponseDto> response = authService.findId(requestBody);
        return response;
    }

    @PostMapping(POST_RESET_PASSWORD)
    public ResponseDto<ResetPasswordPostResponseDto> resetPassword(
            @Valid @RequestBody ResetPasswordPostRequestDto requestBody) {
        ResponseDto<ResetPasswordPostResponseDto> response = authService.resetPassword(requestBody);
        return response;
    }

    @PostMapping(POST_SEND_PASSWORD_EMAIL)
    public ResponseEntity<ResponseDto<Boolean>> sendPasswordEmail(@RequestBody SendPasswordEmailRequestDto requestBody) {
        ResponseDto<Boolean> response = authService.sendPasswordEmail(requestBody);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

}