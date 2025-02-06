package com.a1.a1.dto.response.order;

import com.a1.a1.entity.OrderEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderPostResponseDto {

    private boolean orderUserWhether;
    private String orderGuestPassword;
    private String orderGuestPasswordCheck;
    private String orderUserId;
    private String orderGiftCode;
    @NotBlank
    private String orderUserName;
    @NotBlank
    private String orderUserPhone;
    @NotBlank
    private String orderUserEmail;
    @NotBlank
    private String orderRecieptName;
    @NotBlank
    private String orderRecieptPhone;
    @NotBlank
    private String orderShipAddress;
    @NotBlank
    private String orderShipAddressDetail;
    private String orderShipMessage;

    @NotNull
    private int productId;
    @NotNull
    private int orderCount;

    // 생성자 수정: OrderEntity에서 필요한 값을 가져오기
    public OrderPostResponseDto(OrderEntity orderEntity) {
        this.orderUserName = orderEntity.getOrderUserName();
        this.orderUserPhone = orderEntity.getOrderUserPhone();
        this.orderUserEmail = orderEntity.getOrderUserEmail();
        this.orderRecieptName = orderEntity.getOrderRecieptName();
        this.orderRecieptPhone = orderEntity.getOrderRecieptPhone();
        this.orderShipAddress = orderEntity.getOrderShipAddress();
        this.orderShipAddressDetail = orderEntity.getOrderShipAddressDetail();
        this.orderShipMessage = orderEntity.getOrderShipMessage();
        this.orderGiftCode = String.valueOf(orderEntity.getOrderGiftCode());
        this.orderUserId = orderEntity.getOrderUserId();
        this.orderUserWhether = orderEntity.isOrderUserWhether();
       // 확인할 필요 있음
    }
}
