package com.mong.mmbs.dto.response.cart;

import com.mong.mmbs.entity.CartEntity;
import com.mong.mmbs.entity.ProductEntity;

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
		this.cartProductName = product.getProductTitle();
		this.cartProductImage = product.getProductImageUrl();
		this.cartProductPrice = product.getProductPrice();
		this.cartProductAmount = cartEntity.getCartProductAmount();
	}
	
}
