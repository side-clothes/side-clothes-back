package com.a1.a1.dto.response.order;

import com.a1.a1.entity.OrderDetailEntity;
import com.a1.a1.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderGetListResponseDto {

    private OrderEntity orderEntity;
    private List<OrderDetailEntity> orderDetailList;

}