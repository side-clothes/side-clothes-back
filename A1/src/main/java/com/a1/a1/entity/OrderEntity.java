package com.a1.a1.entity;

import com.a1.a1.dto.request.order.OrderPostRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
@Entity(name="orders")
@Builder
public class OrderEntity {
    //  주문번호 uuid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    //  회원 아이디
    @Column(name = "user_id")
    private Long userId;

    // 주문자 전화번호
    @Column(name = "order_user_phone")
    private String orderUserPhone;

    //  할인 코드
    @Column(name = "coupon_id")
    private Long couponId;

    // 주문 날짜
    @Column(name = "order_datetime")
    private Date orderDateTime;

    // 배송지 관리
    @Column(name = "delivery_address_id")
    private Long deliveryAddressId;

    // 수령인 이름
    @Column(name = "order_receipt_name")
    private String orderReceiptName;

    // 수령인 전화번호
    @Column(name = "order_receipt_phone")
    private String orderReceiptPhone;

    // 수령인 주소
    @Column(name = "order_ship_address")
    private String orderShipAddress;

    // 수령인 상세 주소
    @Column(name = "order_ship_address_detail")
    private String orderShipAddressDetail;

    // 최종 결제 금액
    @Column(name = "order_total_price")
    private int orderTotalPrice;

    // 주문 상태
//    @Enumerated(EnumType.STRING)
//    @Column(name = "order_status")
//    private OrderStatus orderStatus;

    // 배송 회사
    @Column(name = "order_ship_company")
    private String orderShipCompany;

    // 송장 번호
    @Column(name = "order_ship_number")
    private String orderShipNumber;

    // 베송 메세지
    @Column(name = "order_ship_message")
    private String orderShipMessage;

}
