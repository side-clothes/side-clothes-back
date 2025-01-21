package com.a1.a1.entity;

import com.a1.a1.dto.request.order.OrderPostRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_details")
@Entity(name="order_details")
public class OrderDetailEntity {
    //	주문상세 시퀀스
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailSeq;
    //	주문번호
    private String orderNumber;
    //	제품 아이디
    private int productId;
    //	개당 금액
    private int productPrice;
    //	제품 이름
    private String productTitle;
    //	제품 이미지
    private String productImageUrl;
    //	갯수
    private int productCount;

    public OrderDetailEntity(OrderPostRequestDto dto, OrderEntity order, ProductEntity product) {
        this.productId = dto.getProductId();
        this.productCount = dto.getOrderCount();
        this.orderNumber = order.getOrderNumber();
        this.productPrice = product.getProductPrice();
        this.productTitle = product.getProductName();
        this.productImageUrl = product.getProductImageUrl();
    }
}
