package com.mong.mmbs.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendPasswordEmailRequestDto {

  @NotBlank
  private String userEmail;
  
}
