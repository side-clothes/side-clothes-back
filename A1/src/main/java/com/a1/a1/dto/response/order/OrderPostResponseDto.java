package com.a1.a1.dto.response.order;

import com.a1.a1.entity.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPostResponseDto {
    private Long orderId;

    private Long userId;

    private Long couponId;

    private String orderReceiptName;

    private String orderReceiptPhone;

    private String orderShipAddress;

    private String orderShipAddressDetail;

    private LocalDateTime orderDateTime;

    private Long deliveryAddressId;

    private int orderTotalPrice;

    private int detailSeq;

    private Long productId;

    private int productPrice;

    private String productName;

    private String productImgUrl;

    private int productCount;


    public OrderPostResponseDto(OrderEntity orderEntity, OrderDetailEntity orderDetailEntity, Long productId,Long userId, Long couponId,Long deliveryAddressId,int productPrice,String productName) {
        this.orderId = orderEntity.getOrderId();
        this.userId = userId;
        this.couponId = couponId;
        this.orderReceiptName = orderEntity.getOrderReceiptName();
        this.orderReceiptPhone = orderEntity.getOrderReceiptPhone();
        this.orderShipAddress = orderEntity.getOrderShipAddress();
        this.orderShipAddressDetail = orderEntity.getOrderShipAddressDetail();
        this.orderDateTime = LocalDateTime.now();
        this.orderTotalPrice = orderEntity.getOrderTotalPrice();
        this.detailSeq = orderDetailEntity.getOrderDetailSeq();
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productImgUrl = orderDetailEntity.getProductImageUrl();
        this.productCount = orderDetailEntity.getProductCount();
        this.deliveryAddressId = deliveryAddressId;
    }


}