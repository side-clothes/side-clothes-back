package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.order.GiftPatchRequestDto;
import com.a1.a1.dto.request.order.OrderPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.order.GiftGetResponseDto;
import com.a1.a1.dto.response.order.GiftPatchResponseDto;
import com.a1.a1.dto.response.order.OrderGetListResponseDto;
import com.a1.a1.dto.response.order.OrderPostResponseDto;
import com.a1.a1.service.implement.OrderServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiMappingPattern.ORDER)
public class OrderController {


    private final OrderServiceImpl orderService;

    public static final String ORDER_POST = "/";

    public static final String ORDER_GET_LIST = "/list";
    public static final String GIFT_GET_GIFTCODE = "/{giftCode}";

    public static final String GIFT_PATCH = "/gift";

    @PostMapping(ORDER_POST)
    public ResponseDto<OrderPostResponseDto> postOrder(@Valid @RequestBody OrderPostRequestDto requestBody){
        ResponseDto<OrderPostResponseDto> result = orderService.postOrder(requestBody);
        return result;
    }

    @GetMapping(ORDER_GET_LIST)
    public ResponseDto<List<OrderGetListResponseDto>> getOrderList(@AuthenticationPrincipal String userId) {
        ResponseDto<List<OrderGetListResponseDto>> result = orderService.getOrderList(userId);
        return result;
    }

    @GetMapping(GIFT_GET_GIFTCODE)
    public ResponseDto<GiftGetResponseDto> getGiftCode(@PathVariable("giftCode") int giftCode){
        ResponseDto<GiftGetResponseDto> response = orderService.getGiftCode(giftCode);
        return response;
    }

    @PatchMapping(GIFT_PATCH)
    public ResponseDto<GiftPatchResponseDto> patchGift(@Valid @RequestBody GiftPatchRequestDto requsetBody){
        ResponseDto<GiftPatchResponseDto> response = orderService.patchGift(requsetBody);
        return response;
    }

}