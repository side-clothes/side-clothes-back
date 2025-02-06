package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.order.GiftPatchRequestDto;
import com.a1.a1.dto.request.order.OrderPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.order.GiftGetResponseDto;
import com.a1.a1.dto.response.order.GiftPatchResponseDto;
import com.a1.a1.dto.response.order.OrderGetListResponseDto;
import com.a1.a1.dto.response.order.OrderPostResponseDto;
import com.a1.a1.service.OrderService;
import com.a1.a1.service.implement.OrderServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiMappingPattern.ORDER)
public class OrderController {


    private final OrderService orderService;

    public static final String ORDER_POST = "/";

    public static final String ORDER_GET_LIST = "/list";
    public static final String GIFT_GET_GIFTCODE = "/{giftCode}";

    public static final String GIFT_PATCH = "/gift";

    @PostMapping(ORDER_POST)
    public ResponseEntity<ResponseDto<OrderPostResponseDto>> postOrder(@Valid @RequestBody OrderPostRequestDto dto) {
        ResponseDto<OrderPostResponseDto> response = orderService.postOrder(dto);
        HttpStatus status = response.isResult() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(ORDER_GET_LIST)
    public ResponseEntity<ResponseDto<List<OrderGetListResponseDto>>> getOrderList(@AuthenticationPrincipal String userId) {
        ResponseDto<List<OrderGetListResponseDto>> response = orderService.getOrderList(userId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }


    @GetMapping(GIFT_GET_GIFTCODE)
    public ResponseEntity<ResponseDto<GiftGetResponseDto>> getGiftCode(@PathVariable("giftCode") int giftCode){
        ResponseDto<GiftGetResponseDto> response = orderService.getGiftCode(giftCode);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }


    @PatchMapping(GIFT_PATCH)
    public ResponseEntity<ResponseDto<GiftPatchResponseDto>> patchGift(@Valid @RequestBody GiftPatchRequestDto dto){
        ResponseDto<GiftPatchResponseDto> response = orderService.patchGift(dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}