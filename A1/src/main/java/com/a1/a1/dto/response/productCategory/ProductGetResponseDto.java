package com.a1.a1.dto.response.productCategory;

import com.a1.a1.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductGetResponseDto {

    private int productSeq;
    private String productGenre;
    private String productSubGenre;
    private String productNumber;
    private String productName;
    private String productBrand;
    private int productPrice;
    private int productSalesPrice;
    private int productStock;
    private int productLike;
    private String productIntroduceDtl;
    private String productImageUrl;
    private int productSalesCount;

    public ProductGetResponseDto(ProductEntity productEntity) {

        this.productSeq = productEntity.getProductSeq();
        this.productGenre = productEntity.getProductGenre();
        this.productSubGenre = productEntity.getProductSubGenre();
        this.productNumber = productEntity.getProductNumber();
        this.productName = productEntity.getProductName();
        this.productPrice = productEntity.getProductPrice();
        this.productSalesPrice = productEntity.getProductSalesPrice();
        this.productStock = productEntity.getProductStock();
        this.productLike = productEntity.getProductLike();
        this.productIntroduceDtl = productEntity.getProductIntroduceDtl();
        this.productImageUrl = productEntity.getProductImageUrl();
        this.productSalesCount = productEntity.getProductSalesCount();

    }

}