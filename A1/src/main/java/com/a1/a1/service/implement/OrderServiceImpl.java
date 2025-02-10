package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.request.order.GiftPatchRequestDto;
import com.a1.a1.dto.request.order.OrderPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.order.GiftGetResponseDto;
import com.a1.a1.dto.response.order.GiftPatchResponseDto;
import com.a1.a1.dto.response.order.OrderGetListResponseDto;
import com.a1.a1.dto.response.order.OrderPostResponseDto;
import com.a1.a1.entity.*;
import com.a1.a1.repository.*;
import com.a1.a1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ResponseDto<OrderPostResponseDto> postOrder(OrderPostRequestDto dto, Long userId) {

        OrderPostResponseDto data = null;
        userRepository.findById(userId.toString()).orElseThrow(()-> new Error(ResponseMessage.NOT_EXIST_USER));
        Long orderId = dto.getOrderId();
        Long couponId = dto.getCouponId();
        Long productId = dto.getProductId();
        String orderReceiptName = dto.getOrderReceiptName();
        String orderReceiptPhone = dto.getOrderReceiptPhone();
        String orderShipAddress = dto.getOrderShipAddress();
        String orderShipAddressDetail = dto.getOrderShipAddressDetail();
        Long deliveryAddressId = dto.getDeliveryAddressId();
        int orderTotalPrice = dto.getOrderTotalPrice();
        String orderShipMessage = dto.getOrderShipMessage();
        LocalDateTime now = LocalDateTime.now();
        int productPrice = dto.getProductPrice();
        int orderDetailSeq = dto.getOrderDetailSeq();
        String productName = dto.getProductName();
        String productImgUrl = dto.getProductImgUrl();
        int productCount = dto.getProductCount();
        try {
            OrderEntity orderEntity = OrderEntity.builder()
                    .orderId(orderId)
                    .couponId(couponId)
                    .orderReceiptName(orderReceiptName)
                    .orderReceiptPhone(orderReceiptPhone)
                    .orderShipAddress(orderShipAddress)
                    .orderShipAddressDetail(orderShipAddressDetail)
                    .deliveryAddressId(deliveryAddressId)
                    .orderTotalPrice(orderTotalPrice)
                    .orderShipMessage(orderShipMessage)
                    .build();
            orderRepository.save(orderEntity);
            OrderDetailEntity orderDetailEntity = OrderDetailEntity.builder()
                    .orderId(orderId)
                    .productId(productId)
                    .productName(productName)
                    .productPrice(productPrice)
                    .productCount(productCount)
                    .orderDetailSeq(orderDetailSeq)
                    .productImageUrl(productImgUrl)
                    .build();
            orderDetailRepository.save(orderDetailEntity);
            data = new OrderPostResponseDto(orderEntity,orderDetailEntity,productId,userId,couponId,deliveryAddressId,productPrice,productName);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);

    }

    @Override
    public ResponseDto<List<OrderGetListResponseDto>> getOrderList(Long userId) {
        return null;
    }




//    public ResponseDto<GiftPatchResponseDto> patchGift(GiftPatchRequestDto dto){
//
//        GiftPatchResponseDto data = null;
//
//        int orderGiftCode = dto.getOrderGiftCode();
//        String orderNumber = dto.getOrderNumber();
//
//        try {
//
//            OrderEntity orderEntity = orderRepository.findByOrderId(Integer.parseInt(orderId));
//            if (orderEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_ORDER);
//
//            orderEntity.setOrderGiftCode(orderGiftCode);
//            orderRepository.save(orderEntity);
//
//            data = new GiftPatchResponseDto(dto);
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//        }
//
//        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
//
//    }
}