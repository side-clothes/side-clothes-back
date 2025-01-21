package com.a1.a1.entity;

import com.a1.a1.dto.request.auth.SignUpRequestDto;
import com.a1.a1.dto.request.user.UserPatchRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Entity(name="users")
public class UserEntity {
    //	아이디
    @Id
    private String userId;
    //	비밀번호
    private String userPassword;
    //	이메일
    private String userEmail;
    //	주소
    private String userAddress;
    //	상세 주소
    private String userAddressDetail;
    //	이름
    private String userName;
    //	전화번호
    private String userPhone;
    //	생일
    private String userBirth;
    //	가입 날짜
    private String userSignUpDate;
    //	탈퇴 날짜
    private String userWithdraw;

    public UserEntity(SignUpRequestDto dto) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        this.userId = dto.getUserId();
        this.userPassword = dto.getUserPassword();
        this.userEmail = dto.getUserEmail();
        this.userAddress = dto.getUserAddress();
        this.userAddressDetail =dto.getUserAddressDetail();
        this.userName = dto.getUserName();
        this.userPhone = dto.getUserPhone();
        this.userBirth = dto.getUserBirth();
        this.userSignUpDate = dateFormat.format(new Date());
    }

    public void setPatchUser(UserPatchRequestDto dto) {

        this.userAddress = dto.getUserAddress();
        this.userAddressDetail =dto.getUserAddressDetail();
        this.userName = dto.getUserName();
        this.userPhone = dto.getUserPhone();
        this.userBirth = dto.getUserBirth();

    }

}