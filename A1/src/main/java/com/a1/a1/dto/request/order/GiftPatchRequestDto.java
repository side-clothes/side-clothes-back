package com.a1.a1.dto.request.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiftPatchRequestDto {
    private int orderGiftCode;
    private String orderNumber;
}
