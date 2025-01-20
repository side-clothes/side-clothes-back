package com.mong.mmbs.service;

import com.mong.mmbs.dto.request.cart.CartAmountPatchRequestDto;
import com.mong.mmbs.dto.request.cart.CartPostRequestDto;
import com.mong.mmbs.dto.response.ResponseDto;
import com.mong.mmbs.dto.response.cart.*;

public interface CartService {
    ResponseDto<CartPostResponseDto> post(String userId, CartPostRequestDto dto);
    ResponseDto<CartGetResponseDto> get(String userId);
    ResponseDto<CartAmountPatchResponseDto> amount(CartAmountPatchRequestDto dto);
    ResponseDto<CartDeleteResponseDto> delete(String userId, int cartId);
    ResponseDto<CartDeleteAllResponseDto> deleteAll(String cartUserId);
}
