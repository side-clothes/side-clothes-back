package com.a1.a1.dto.response.user;

import com.a1.a1.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPatchResponseDto {
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userAddress;
    private String userAddressDetail;
    private String userName;
    private String userPhone;
    private String userBirth;
    private String userSignUpDate;
    private String userWithdraw;

    public UserPatchResponseDto(UserEntity userEntity) {

        this.userId = userEntity.getUserId();
        this.userPassword = userEntity.getUserPassword();
        this.userEmail = userEntity.getUserEmail();
        this.userAddress = userEntity.getUserAddress();
        this.userAddressDetail = userEntity.getUserAddressDetail();
        this.userName = userEntity.getUserName();
        this.userPhone = userEntity.getUserPhone();
        this.userBirth = userEntity.getUserBirth();
        this.userSignUpDate = userEntity.getSignUpDate();

    }
}