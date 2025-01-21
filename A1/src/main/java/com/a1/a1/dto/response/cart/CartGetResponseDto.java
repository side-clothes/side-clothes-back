package com.a1.a1.dto.response.cart;

import com.a1.a1.entity.CartEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartGetResponseDto {
    List<CartEntity> cartList;
}