package com.a1.a1.service;

import com.a1.a1.dto.request.order.GiftPatchRequestDto;
import com.a1.a1.dto.request.order.OrderPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.order.GiftGetResponseDto;
import com.a1.a1.dto.response.order.GiftPatchResponseDto;
import com.a1.a1.dto.response.order.OrderGetListResponseDto;
import com.a1.a1.dto.response.order.OrderPostResponseDto;

import java.util.List;

public interface OrderService {
    ResponseDto<OrderPostResponseDto> postOrder(OrderPostRequestDto dto);
    ResponseDto<List<OrderGetListResponseDto>> getOrderList(String userId);
    ResponseDto<GiftGetResponseDto> getGiftCode(int giftCode);
    ResponseDto<GiftPatchResponseDto> patchGift(GiftPatchRequestDto dto);

}