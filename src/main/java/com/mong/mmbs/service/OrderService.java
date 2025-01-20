package com.mong.mmbs.service;

import com.mong.mmbs.dto.request.order.GiftPatchReqeustDto;
import com.mong.mmbs.dto.request.order.OrderPostRequestDto;
import com.mong.mmbs.dto.response.ResponseDto;
import com.mong.mmbs.dto.response.order.GiftGetResponseDto;
import com.mong.mmbs.dto.response.order.GiftPatchResponseDto;
import com.mong.mmbs.dto.response.order.OrderGetListResponseDto;
import com.mong.mmbs.dto.response.order.OrderPostResponseDto;

import java.util.List;

public interface OrderService {
    ResponseDto<OrderPostResponseDto> postOrder(OrderPostRequestDto dto);
    ResponseDto<List<OrderGetListResponseDto>> getOrderList(String userId);
    ResponseDto<GiftGetResponseDto> getGiftCode(int giftCode);
    ResponseDto<GiftPatchResponseDto> patchGift(GiftPatchReqeustDto dto);

}
