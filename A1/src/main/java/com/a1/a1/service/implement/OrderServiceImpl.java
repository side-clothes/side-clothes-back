package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.request.order.GiftPatchRequestDto;
import com.a1.a1.dto.request.order.OrderPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.order.GiftGetResponseDto;
import com.a1.a1.dto.response.order.GiftPatchResponseDto;
import com.a1.a1.dto.response.order.OrderGetListResponseDto;
import com.a1.a1.dto.response.order.OrderPostResponseDto;
import com.a1.a1.entity.GiftEntity;
import com.a1.a1.entity.OrderDetailEntity;
import com.a1.a1.entity.OrderEntity;
import com.a1.a1.repository.GiftRepository;
import com.a1.a1.repository.OrderDetailRepository;
import com.a1.a1.repository.OrderRepository;
import com.a1.a1.repository.ProductRepository;
import com.a1.a1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final GiftRepository giftRepository;

    public ResponseDto<OrderPostResponseDto> postOrder(OrderPostRequestDto dto) {

        OrderPostResponseDto data = null;

        boolean orderUserWhether = false;
        String orderGuestPassword = dto.getOrderGuestPassword();
        String orderGuestPasswordCheck = dto.getOrderGuestPasswordCheck();
        String orderUserId = dto.getOrderUserId();
        int orderGiftCode = dto.getOrderGiftCode();
        int productId = dto.getProductId();
        int orderCount = dto.getOrderCount();
        String orderUserName = dto.getOrderUserName();
        String orderUserPhone = dto.getOrderUserPhone();
        String orderUserEmail = dto.getOrderUserEmail();
        String orderRecieptName = dto.getOrderRecieptName();
        String orderRecieptPhone = dto.getOrderRecieptPhone();
        String orderShipAddress = dto.getOrderShipAddress();
        String orderShipAddressDetail = dto.getOrderShipAddressDetail();
        String orderShipMessage = dto.getOrderShipMessage();
        try {
            OrderEntity orderEntity = OrderEntity.builder()
                    .orderUserName(orderUserName)
                    .orderUserPhone(orderUserPhone)
                    .orderUserEmail(orderUserEmail)
                    .orderRecieptName(orderRecieptName)
                    .orderRecieptPhone(orderRecieptPhone)
                    .orderShipAddress(orderShipAddress)
                    .orderShipAddressDetail(orderShipAddressDetail)
                    .orderShipMessage(orderShipMessage)
                    .orderGiftCode(orderGiftCode)
                    .orderUserWhether(orderUserWhether)
                    .orderGuestPassword(orderGuestPassword)
                    .orderGuestPassword(orderGuestPasswordCheck)
                    .orderUserId(orderUserId)
                    .build();
            orderRepository.save(orderEntity);
            data = new OrderPostResponseDto(orderEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }




    public ResponseDto<List<OrderGetListResponseDto>> getOrderList(String userId) {

        List<OrderGetListResponseDto> data = new ArrayList<OrderGetListResponseDto>();

        try {

            List<OrderEntity> orderList = orderRepository.findByOrderUserId(userId);

            for ( OrderEntity order : orderList ) {

                List<OrderDetailEntity> detailList = orderDetailRepository.findByOrderNumber(order.getOrderNumber());
                OrderGetListResponseDto resultItem = new OrderGetListResponseDto(order, detailList);

                data.add(resultItem);

            }

        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<GiftGetResponseDto> getGiftCode(int giftCode){

        GiftGetResponseDto data = null;

        try {

            List<GiftEntity> giftList = giftRepository.findAll();

            data = new GiftGetResponseDto(giftList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<GiftPatchResponseDto> patchGift(GiftPatchRequestDto dto){

        GiftPatchResponseDto data = null;

        int orderGiftCode = dto.getOrderGiftCode();
        String orderNumber = dto.getOrderNumber();

        try {

            OrderEntity orderEntity = orderRepository.findByOrderNumber(orderNumber);
            if (orderEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_ORDER);

            orderEntity.setOrderGiftCode(orderGiftCode);
            orderRepository.save(orderEntity);

            data = new GiftPatchResponseDto(dto);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
}