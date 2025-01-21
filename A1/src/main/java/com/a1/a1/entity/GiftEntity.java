package com.a1.a1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gifts")
@Entity(name = "gifts")
public class GiftEntity {
    //	사은품 코드
    @Id
    private int giftCode;
    //  사은품 이름
    private String giftName;
    //  사은품 이미지
    private String giftImage;

}