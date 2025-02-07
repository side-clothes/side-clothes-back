package com.a1.a1.entity;

import com.a1.a1.dto.request.cart.CartPostRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
@Entity(name = "carts")
public class CartEntity {
    //  카트 시퀀스
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    // 유저아이디
    @Column(name = "user_id")
    private Long userId;

    // 제품 아이디
    @Column(name = "product_id")
    private Long productId;

    // 제품 이름
    @Column(name = "cart_product_name")
    private String cartProductName;

    // 제품 가격
    @Column(name = "cart_product_price")
    private int cartProductPrice;

    // 제품 썸네일 이미지
    @Column(name = "product_thumbnail_image_url")
    private String productThumbnailImageUrl;

    // 제품 개수
    @Column(name = "cart_product_amount")
    private int cartProductAmount;





    public CartEntity(Long userId, CartPostRequestDto dto, ProductEntity product) {
        this.userId = userId;
        this.productId = product.getProductId();
        this.cartProductName = product.getProductName();

        this.cartProductPrice = product.getProductPrice();
        this.productThumbnailImageUrl = product.getProductThumbnailImageUrl();
        this.cartProductAmount = dto.getCartProductAmount();
    }
}