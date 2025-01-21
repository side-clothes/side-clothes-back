package com.a1.a1.dto.request.cart;

import com.a1.a1.entity.CartEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CartAmountPatchRequestDto {
    private List<CartEntity> cartList;
}