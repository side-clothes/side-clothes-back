package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.user.UserPatchRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.user.UserDeleteResponseDto;
import com.a1.a1.dto.response.user.UserGetResponseDto;
import com.a1.a1.dto.response.user.UserPatchResponseDto;
import com.a1.a1.service.implement.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiMappingPattern.USER)
public class UserController {

    private final UserServiceImpl userService;

    private static final String GET_USER = "/";
    private static final String PATCH_USER_UPDATE = "/";
    private static final String DELETE_USER = "/{userEmail}";

    @GetMapping(GET_USER)
    public ResponseDto<UserGetResponseDto> getUser(@AuthenticationPrincipal String userId) {
        ResponseDto<UserGetResponseDto> response = userService.getUser(userId);
        return response;
    }

    @PatchMapping(PATCH_USER_UPDATE)
    public ResponseDto<UserPatchResponseDto> patchUser(@AuthenticationPrincipal String userId, @Valid @RequestBody UserPatchRequestDto dto) {
        ResponseDto<UserPatchResponseDto> response = userService.patchUser(userId, dto);
        return response;
    }

    @DeleteMapping(DELETE_USER)
    public ResponseDto<UserDeleteResponseDto> deleteUser(@AuthenticationPrincipal String userId, @PathVariable("userEmail") String userEmail) {
        ResponseDto<UserDeleteResponseDto> response = userService.deleteUser(userId, userEmail);
        return response;
    }

}