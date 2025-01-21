package com.a1.a1.dto.response.order;

import com.a1.a1.entity.OrderDetailEntity;
import com.a1.a1.entity.OrderEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderPostResponseDto {

    OrderEntity orderEntity;
    OrderDetailEntity orderDetailEntity;

    public OrderPostResponseDto(OrderEntity orderEntity, OrderDetailEntity orderDetailEntity) {

        this.orderEntity = orderEntity;
        this.orderDetailEntity = orderDetailEntity;
    }

}