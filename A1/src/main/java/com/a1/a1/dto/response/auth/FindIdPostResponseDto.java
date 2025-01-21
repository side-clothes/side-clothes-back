package com.a1.a1.dto.response.auth;

import com.a1.a1.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindIdPostResponseDto {

    private String userId;

    public FindIdPostResponseDto(UserEntity userEntity) {
        this.userId = userEntity.getUserId();

    }
}