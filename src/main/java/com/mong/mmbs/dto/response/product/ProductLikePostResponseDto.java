package com.mong.mmbs.dto.response.product;

import com.mong.mmbs.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLikePostResponseDto {

  private int productSeq;
	private String productGenre;
	private String productSubGenre;
	private int productIsbn;
	private String productTitle;
	private String productWriter;
	private String productPublisher;
	private String productAge;
	private String productSubAge;
	private String productPublicationDate;
	private int productPrice;
	private int productSalesPrice;
	private int productStock;
	private int productLike;
	private String productIntroduceDtl;
	private String productImageUrl;
	private int productSalesCount;

  public ProductLikePostResponseDto(ProductEntity productEntity) {

      this.productSeq = productEntity.getProductSeq();
      this.productGenre = productEntity.getProductGenre();
      this.productSubGenre = productEntity.getProductSubGenre();
      this.productIsbn = productEntity.getProductIsbn();
      this.productTitle = productEntity.getProductTitle();
      this.productWriter = productEntity.getProductWriter();
      this.productPublisher = productEntity.getProductPublisher();
      this.productAge = productEntity.getProductAge();
      this.productSubAge = productEntity.getProductSubAge();
      this.productPublicationDate = productEntity.getProductPublicationDate();
      this.productPrice = productEntity.getProductPrice();
      this.productSalesPrice = productEntity.getProductSalesPrice();
      this.productStock = productEntity.getProductStock();
      this.productLike = productEntity.getProductLike();
      this.productIntroduceDtl = productEntity.getProductIntroduceDtl();
      this.productImageUrl = productEntity.getProductImageUrl();
      this.productSalesCount = productEntity.getProductSalesCount();

  }
  
}
