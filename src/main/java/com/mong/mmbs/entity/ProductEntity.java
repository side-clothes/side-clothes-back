package com.mong.mmbs.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
@Entity(name="products")
public class ProductEntity {
//	고유번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productSeq;
//	장르 [국내도서, 외국도서, 전집, 토이/교구, 부모님의 서재]
	private String productGenre;
//	세부 장르
	private String productSubGenre;
//	고유번호
	private String productNumber;
//	상품명
	private String productName;
//	브랜드
	private String productBrand;
//	출판일
	private String productPublicationDate;
//	가격
	private int productPrice;
//	할인가격
	private int productSalesPrice;
//	재고
	private int productStock;
//	좋아요
	private int productLike;
//	상세 설명
	private String productIntroduceDtl;
//	이미지
	private String productImageUrl;
//	판매량
	private int productSalesCount;

}