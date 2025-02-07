package com.a1.a1.dto.response.cart;

import com.a1.a1.entity.CartEntity;
import com.a1.a1.entity.ProductEntity;
import com.a1.a1.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartPostResponseDto {
    private Long cartId;
    private Long productId;
    private Long userId;
    private String cartProductName;
    private int cartProductPrice;
    private String productThumbnailImageUrl;
    private int cartProductAmount;

    public CartPostResponseDto(CartEntity cartEntity, Long productId, Long userId, String cartProductName, int cartProductPrice, String productThumbnailImageUrl, int cartProductAmount) {
        this.cartId = cartEntity.getCartId();
        this.productId = productId;
        this.userId = userId;
        this.cartProductName = cartProductName;
        this.cartProductPrice = cartProductPrice;
        this.productThumbnailImageUrl = productThumbnailImageUrl;
        this.cartProductAmount = cartProductAmount;

    }
}