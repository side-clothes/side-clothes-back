package com.a1.a1.entity;

import com.a1.a1.dto.request.order.OrderPostRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_details")
@Entity(name="order_details")
@Builder
public class OrderDetailEntity {
    //	주문상세 시퀀스
    @Id
    @Column(name = "order_detail_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailSeq;

    //	주문번호
    @Column(name = "order_id")
    private Long orderId;

    // 제품 번호
    @Column(name = "product_id")
    private Long productId;

    // 개당 금액
    @Column(name = "product_price")
    private int productPrice;

    // 제품 이름
    @Column(name = "product_name")
    private String productName;

    // 제품 이미지
    @Column(name = "product_image_url")
    private String productImageUrl;

    // 제품 수량
    @Column(name = "product_count")
    private int productCount;
}
