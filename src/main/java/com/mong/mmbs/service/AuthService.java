package com.mong.mmbs.service;

import com.mong.mmbs.dto.request.auth.*;
import com.mong.mmbs.dto.response.ResponseDto;
import com.mong.mmbs.dto.response.auth.FindIdPostResponseDto;
import com.mong.mmbs.dto.response.auth.ResetPasswordPostResponseDto;
import com.mong.mmbs.dto.response.auth.SignInPostResponseDto;
import com.mong.mmbs.dto.response.auth.SignUpPostResponseDto;

public interface AuthService {
    ResponseDto<SignUpPostResponseDto> signUp(SignUpRequestDto dto);
    ResponseDto<FindIdPostResponseDto> findId(FindIdRequestDto dto);
    ResponseDto<ResetPasswordPostResponseDto> resetPassword(resetPasswordPostRequestDto dto);
    ResponseDto<SignInPostResponseDto> signIn(SignInRequestDto dto);
    ResponseDto<Boolean> sendPasswordEmail(SendPasswordEmailRequestDto dto);
}
