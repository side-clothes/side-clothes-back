package com.mong.mmbs.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserPatchRequestDto {
  	@NotBlank
	private String userAddress;
	@NotBlank
	private String userAddressDetail;
	@NotBlank
	private String userName;
	@NotBlank
	private String userPhone;
	private String userBirth;

}
