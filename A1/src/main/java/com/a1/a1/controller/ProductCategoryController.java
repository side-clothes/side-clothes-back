package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGenreGetListResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGetResponseDto;
import com.a1.a1.entity.type.Main_category;
import com.a1.a1.entity.type.Recommend_category;
import com.a1.a1.service.implement.ProductCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiMappingPattern.PRODUCT_CATEGORY)
public class ProductCategoryController<BookListServicevice> {


    private final ProductCategoryServiceImpl productCategoryService;

    private static final String GET_PRODUCT_GENRE_LIST = "/bookList2/{produtGenreCategory}/{productSubGenreCategory}";
    private static final String GET_PRODUCT = "/{productSeq}";



    // 장르별 상품 조회 (미구현)
    @GetMapping(GET_PRODUCT_GENRE_LIST)
    public ResponseDto<ProductGenreGetListResponseDto> getProductGenreList(@PathVariable("MainCategory") Enum<Main_category> mainCategory, @PathVariable("RecommendCategory")  Enum<Recommend_category> recommendCategory) {
        ResponseDto<ProductGenreGetListResponseDto> response
                = productCategoryService.getProductGenreList(mainCategory, recommendCategory);
        return response;
    }

    // 단건 상품 조회 (미구현)
    @GetMapping(GET_PRODUCT)
    public ResponseDto<ProductGetResponseDto> getProduct(@PathVariable("productSeq") int productSeq) {
        ResponseDto<ProductGetResponseDto> response
                = productCategoryService.getProduct(productSeq);
        return response;
    }

}