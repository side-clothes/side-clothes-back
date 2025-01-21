package com.a1.a1.dto.response.auth;

import com.a1.a1.entity.RecommendEntity;
import com.a1.a1.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SignUpPostResponseDto {

    UserEntity userEntity;
    RecommendEntity recommendEntity;

    public SignUpPostResponseDto(UserEntity userEntity, RecommendEntity recommendEntity) {

        this.userEntity = userEntity;
        this.recommendEntity = recommendEntity;

    }
}
