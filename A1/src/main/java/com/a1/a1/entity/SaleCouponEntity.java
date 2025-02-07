package com.a1.a1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sale_coupons")
@Entity
public class SaleCouponEntity {
    //	사은품 코드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "sale_percent" )
    private Double salePercent;

    @Column(name = "coupon_issue_date")
    private Date couponIssueDate;

    @Column(name = "coupon_expiration_date")
    private Date couponExpirationDate;

}