package com.a1.a1.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FindIdRequestDto {

    @NotBlank
    private String userEmail;
    @NotBlank
    private String userName;

}