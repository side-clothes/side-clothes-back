package com.a1.a1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery_addresses")
@Entity
public class DeliveryAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_address_id")
    private Long deliveryAddressId;

    @Column(name = "order_receipt_name")
    private String orderReceiptName;

    @Column(name = "order_receipt_phone")
    private String orderReceiptPhone;

    @Column(name = "order_ship_address")
    private String orderShipAddress;

    @Column(name = "order_ship_address_detail")
    private String orderShipAddressDetail;
}
