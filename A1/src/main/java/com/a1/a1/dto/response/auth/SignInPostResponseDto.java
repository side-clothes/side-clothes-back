package com.a1.a1.dto.response.auth;

import com.a1.a1.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInPostResponseDto {
    private String token;
    private int exprTime;
    private UserEntity user;
}