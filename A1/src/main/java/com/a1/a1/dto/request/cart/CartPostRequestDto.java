package com.a1.a1.dto.request.cart;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartPostRequestDto {

    @NotNull
    private int cartProductId;
    @NotNull
    private int cartProductAmount;

}