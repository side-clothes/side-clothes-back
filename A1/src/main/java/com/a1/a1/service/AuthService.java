package com.a1.a1.service;

import com.a1.a1.dto.request.auth.*;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.auth.FindIdPostResponseDto;
import com.a1.a1.dto.response.auth.ResetPasswordPostResponseDto;
import com.a1.a1.dto.response.auth.SignInPostResponseDto;
import com.a1.a1.dto.response.auth.SignUpPostResponseDto;

public interface AuthService {
    ResponseDto<SignUpPostResponseDto> signUp(SignUpRequestDto dto);
    ResponseDto<FindIdPostResponseDto> findId(FindIdRequestDto dto);
    ResponseDto<ResetPasswordPostResponseDto> resetPassword(ResetPasswordPostRequestDto dto);
    ResponseDto<SignInPostResponseDto> signIn(SignInRequestDto dto);
    ResponseDto<Boolean> sendPasswordEmail(SendPasswordEmailRequestDto dto);
}
