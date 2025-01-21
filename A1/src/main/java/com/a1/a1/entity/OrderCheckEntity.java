package com.a1.a1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "order_checks")
@Entity(name = "order_checks")
@Data
public class OrderCheckEntity {

    @Id
    private String orderNumber;
    // 개당 금액
    private int productPrice;
    // 제품 이름
    private String productTitle;
    // 제품 이미지
    private String productImageUrl;
    // 갯수
    private int productCount;
    // 주문 날짜
    private String orderDatetime;
    // 주문 상태
    private int orderStatus;
    // 최종 결제 금액
    private int orderTotalPrice;
    // 배송 회사
    private String orderShipCompany;

}