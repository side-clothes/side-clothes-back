package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.request.cart.CartAmountPatchRequestDto;
import com.a1.a1.dto.request.cart.CartPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.cart.*;
import com.a1.a1.entity.CartEntity;
import com.a1.a1.entity.ProductEntity;
import com.a1.a1.repository.CartRepository;
import com.a1.a1.repository.ProductRepository;
import com.a1.a1.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    // 카트 등록
    public ResponseDto<CartPostResponseDto> postCart(String userId, CartPostRequestDto dto) {
        CartPostResponseDto data = null;
        int cartProductId = dto.getCartProductId();
        int cartProductAmount = dto.getCartProductAmount();
        String cartProductName = dto.getCartProductName();
        String cartProductImage = dto.getCartProductImg();
        int cartProductPrice = dto.getCartProductPrice();
        try {
            CartEntity cartEntity = CartEntity.builder()
                    .cartProductId(cartProductId)
                    .cartProductPrice(cartProductAmount)
                    .cartUserId(userId)
                    .cartProductAmount(cartProductAmount)
                    .cartProductName(cartProductName)
                    .cartProductImage(cartProductImage)
                    .cartProductPrice(cartProductPrice)
                    .build();
            cartRepository.save(cartEntity);
            ProductEntity ProductEntity = new ProductEntity();
            productRepository.save(ProductEntity);
            data = new CartPostResponseDto(cartEntity);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
    }

    public ResponseDto<CartGetResponseDto> get(String userId) {

        CartGetResponseDto data = null;

        try {

            List<CartEntity> cartList = cartRepository.findByCartUserId(userId);
            if (cartList == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_CARTLIST);

            data = new CartGetResponseDto(cartList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<CartAmountPatchResponseDto> amount(CartAmountPatchRequestDto dto) {

        CartAmountPatchResponseDto data = null;

        try {

            List<CartEntity> cartList = dto.getCartList();
            cartRepository.saveAll(cartList);

            data = new CartAmountPatchResponseDto(cartList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 카트 삭제 아이디로
    @Override
    @Transactional
    public ResponseDto<Boolean> deleteByCartId(int cartId) {
        try {
            cartRepository.deleteByCartId(cartId);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, true);
    }

    public ResponseDto<CartDeleteAllResponseDto> deleteAll(String cartUserId) {

        CartDeleteAllResponseDto data = null;

        try {

            List<CartEntity> cartList = cartRepository.findByCartUserId(cartUserId);
            if (cartList == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_CART);

            cartRepository.deleteAll(cartList);

            cartList = cartRepository.findByCartUserId(cartUserId);

            data = new CartDeleteAllResponseDto(cartList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}