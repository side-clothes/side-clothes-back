package com.a1.a1.dto.response.product;

import com.a1.a1.entity.ProductEntity;
import com.a1.a1.entity.type.Main_category;
import com.a1.a1.entity.type.Recommend_category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailGetProductSeqResponseDto {

    private int productId;
    private Enum<Main_category> mainCategory;
    private Enum<Recommend_category> recommendCategory;
    private String productNumber;
    private String productName;
    private String productBrand;
    private int productPrice;
    private int productStock;
    private int productLike;
    private String productIntroduceDtl;
    private String productImageUrl;
    private int productSalesCount;

    public ProductDetailGetProductSeqResponseDto(ProductEntity productEntity) {
        this.productId = productEntity.getProductId();
        this.mainCategory = productEntity.getMainCategory();
        this.recommendCategory = productEntity.getRecommendCategory();
        this.productNumber = productEntity.getProductNumber();
        this.productName = productEntity.getProductName();
        this.productBrand = productEntity.getProductBrand();
        this.productPrice = productEntity.getProductPrice();
        this.productStock = productEntity.getProductStock();
        this.productLike = productEntity.getProductLike();
        this.productIntroduceDtl = productEntity.getProductIntroduceDtl();
        this.productImageUrl = productEntity.getProductThumbnailImageUrl();
        this.productSalesCount = productEntity.getProductSalesCount();
    }
}