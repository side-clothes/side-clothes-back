package com.a1.a1.dto.response.order;

import com.a1.a1.dto.request.order.GiftPatchRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftPatchResponseDto {

    private String orderNumber;
    private int orderGiftCode;


    public GiftPatchResponseDto(GiftPatchRequestDto dto) {

        this.orderNumber = dto.getOrderNumber();
        this.orderGiftCode = dto.getOrderGiftCode();

    }

}
