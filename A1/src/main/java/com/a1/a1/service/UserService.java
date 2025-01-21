package com.a1.a1.service;

import com.a1.a1.dto.request.user.UserPatchRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.user.UserDeleteResponseDto;
import com.a1.a1.dto.response.user.UserGetResponseDto;
import com.a1.a1.dto.response.user.UserPatchResponseDto;

public interface UserService {
    ResponseDto<UserGetResponseDto> getUser(String userId);
    ResponseDto<UserPatchResponseDto> patchUser(String userId, UserPatchRequestDto dto);
    ResponseDto<UserDeleteResponseDto> deleteUser(String userId, String userEmail);

}