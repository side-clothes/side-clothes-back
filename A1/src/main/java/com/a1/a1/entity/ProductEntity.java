package com.a1.a1.entity;

import com.a1.a1.entity.type.Main_category;
import com.a1.a1.entity.type.Recommend_category;
import jakarta.persistence.*;
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
    @Column(name = "product_id")
    private int productId;
    //	메인 카테고리
    @Enumerated(EnumType.STRING)
    private Main_category mainCategory;
    //	추천 카테고리
    @Enumerated(EnumType.STRING)
    private Recommend_category recommendCategory;
    //	고유번호
    private String productNumber;
    //	제품명
    private String productName;
    //	브랜드
    private String productBrand;
    //	가격
    private int productPrice;
    //	재고
    private int productStock;
    //	좋아요
    private int productLike;
    //	상세 설명
    private String productIntroduceDtl;
    //	썸네일 이미지
    private String productThumbnailImageUrl;
    //	판매량
    private int productSalesCount;

}
