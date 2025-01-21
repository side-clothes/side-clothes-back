package com.a1.a1.dto.response.auth;

import com.a1.a1.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordPostResponseDto {
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userAddress;
    private String userAddressDetail;
    private String userName;
    private String userPhone;
    private String userKidBirth;
    private String userSignUpDate;
    private String userWithdraw;

    public ResetPasswordPostResponseDto(UserEntity userEntity) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        this.userId = userEntity.getUserId();
        this.userPassword = userEntity.getUserPassword();
        this.userEmail = userEntity.getUserEmail();
        this.userAddress = userEntity.getUserAddress();
        this.userAddressDetail =userEntity.getUserAddressDetail();
        this.userName = userEntity.getUserName();
        this.userPhone = userEntity.getUserPhone();
        this.userKidBirth = userEntity.getUserBirth();
        this.userSignUpDate = dateFormat.format(new Date());

    }

}