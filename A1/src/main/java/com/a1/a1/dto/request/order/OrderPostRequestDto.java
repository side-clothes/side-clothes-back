package com.a1.a1.dto.request.order;

import com.a1.a1.common.util.ProductObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPostRequestDto {


    private Long orderId;

    @NotNull
    private Long userId;

    @NotNull
    private Long couponId;

    @NotNull
    private Long productId;

    @NotNull
    private String orderUserPhone;

    @NotNull
    private Date orderDatetime;

    @NotNull
    private Long deliveryAddressId;

    @NotBlank
    private String orderReceiptName;

    @NotBlank
    private String orderReceiptPhone;

    @NotBlank
    private String orderShipAddress;

    @NotBlank
    private String orderShipAddressDetail;

    private String orderShipMessage;


    private int orderTotalPrice;

    private int orderDetailSeq;

    private int productPrice;

    private String productName;

    private String productImgUrl;

    private int productCount;


}