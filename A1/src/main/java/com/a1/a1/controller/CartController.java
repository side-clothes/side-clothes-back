package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.cart.CartAmountPatchRequestDto;
import com.a1.a1.dto.request.cart.CartPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.cart.*;
import com.a1.a1.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiMappingPattern.CART)
public class CartController {

    private final CartService cartService;

    public static final String CART_POST = "/";

    public static final String CART_GET = "/";

    public static final String CART_PATCH_AMOUNT = "/";

    public static final String CART_DELETE_CARTID = "/{cartId}";
    public static final String CART_DELETE_CARTUSERID = "/all/{cartUserId}";

    // 카트 생성
    @PostMapping(CART_POST)
    public ResponseEntity<ResponseDto<CartPostResponseDto>> postCart(@AuthenticationPrincipal String userId, @Valid @RequestBody CartPostRequestDto requestBody){
        ResponseDto<CartPostResponseDto> response = cartService.postCart(userId, requestBody);
        HttpStatus status = response.isResult() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    // 카트 조회
    @GetMapping(CART_GET)
    public ResponseEntity<ResponseDto<CartGetResponseDto>> get(@AuthenticationPrincipal String userId){
        ResponseDto<CartGetResponseDto> response = cartService.get(userId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    //카트 수정
    @PatchMapping(CART_PATCH_AMOUNT)
    public ResponseDto<CartAmountPatchResponseDto> amount(@Valid @RequestBody CartAmountPatchRequestDto requestBody){
        ResponseDto<CartAmountPatchResponseDto> result = cartService.amount(requestBody);
        return result;
    }

    // 카트 아이디로 삭제
    @DeleteMapping(CART_DELETE_CARTID)
    public ResponseEntity<ResponseDto<Boolean>> deleteByCartId(@PathVariable int cartId){
        ResponseDto<Boolean> response = cartService.deleteByCartId(cartId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }


    @DeleteMapping(CART_DELETE_CARTUSERID)
    public ResponseDto<CartDeleteAllResponseDto> deleteAll(@PathVariable("cartUserId") String cartUserId){
        ResponseDto<CartDeleteAllResponseDto> result = cartService.deleteAll(cartUserId);
        return result;
    }
}