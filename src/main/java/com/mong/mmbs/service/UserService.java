package com.mong.mmbs.service;

import com.mong.mmbs.dto.request.user.UserPatchRequestDto;
import com.mong.mmbs.dto.response.ResponseDto;
import com.mong.mmbs.dto.response.user.UserDeleteResponseDto;
import com.mong.mmbs.dto.response.user.UserGetResponseDto;
import com.mong.mmbs.dto.response.user.UserPatchResponseDto;

public interface UserService {
    ResponseDto<UserGetResponseDto> getUser(String userId);
    ResponseDto<UserPatchResponseDto> patchUser(String userId, UserPatchRequestDto dto);
    ResponseDto<UserDeleteResponseDto> deleteUser(String userId, String userEmail);

}
