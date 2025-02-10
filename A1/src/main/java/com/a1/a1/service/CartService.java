package com.a1.a1.service;

import com.a1.a1.dto.request.cart.CartAmountPatchRequestDto;
import com.a1.a1.dto.request.cart.CartPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.cart.*;

public interface CartService {
    ResponseDto<CartPostResponseDto> postCart(Long userId, CartPostRequestDto dto);
    ResponseDto<CartGetResponseDto> get(Long userId);
    ResponseDto<CartAmountPatchResponseDto> amount(CartAmountPatchRequestDto dto);
    ResponseDto<Boolean> deleteByCartId(Long cartId);
    ResponseDto<CartDeleteAllResponseDto> deleteAll(Long userId);
}
