package com.mong.mmbs.dto.response.user;

import com.mong.mmbs.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGetResponseDto {

	private String userId;
	private String userAddress;
	private String userAddressDetail;
	private String userName;
	private String userPhone;
	private String userKidBirth;

  
  public UserGetResponseDto(UserEntity userEntity) {
		
		this.userId = userEntity.getUserId();
		this.userAddress = userEntity.getUserAddress();
		this.userAddressDetail =userEntity.getUserAddressDetail();
		this.userName = userEntity.getUserName();
		this.userPhone = userEntity.getUserPhone();
		this.userKidBirth = userEntity.getUserKidBirth();
		
	}
}
