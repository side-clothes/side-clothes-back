package com.a1.a1.dto.response.cart;

import com.a1.a1.entity.CartEntity;
import com.a1.a1.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartPostResponseDto {
    private int cartId;
    private String cartUserId;
    private int cartProductId;
    private String cartProductName;
    private String cartProductImage;
    private int cartProductPrice;
    private int cartProductAmount;

    public CartPostResponseDto(CartEntity cartEntity, ProductEntity product) {
        this.cartId = cartEntity.getCartId();
        this.cartUserId = cartEntity.getCartUserId();
        this.cartProductId = product.getProductSeq();
        this.cartProductName = product.getProductName();
        this.cartProductImage = product.getProductImageUrl();
        this.cartProductPrice = product.getProductPrice();
        this.cartProductAmount = cartEntity.getCartProductAmount();
    }

    public CartPostResponseDto(CartEntity cartEntity) {
        this.cartId = cartEntity.getCartId();
        this.cartUserId = cartEntity.getCartUserId();
        this.cartProductId = cartEntity.getCartProductId();
        this.cartProductName = cartEntity.getCartProductName();
        this.cartProductImage = cartEntity.getCartProductImage();
        this.cartProductPrice = cartEntity.getCartProductPrice();
        this.cartProductAmount = cartEntity.getCartProductAmount();
    }
}