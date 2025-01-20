package com.mong.mmbs.service;

import com.mong.mmbs.dto.response.ResponseDto;
import com.mong.mmbs.dto.response.productCategory.ProductAgeGetListResponseDto;
import com.mong.mmbs.dto.response.productCategory.ProductGenreGetListResponseDto;
import com.mong.mmbs.dto.response.productCategory.ProductGetResponseDto;

public interface ProductCategoryService {
    ResponseDto<ProductAgeGetListResponseDto> getProductAgeList(String productAgeCategory, String productSubAgeCategory);
    ResponseDto<ProductGenreGetListResponseDto> getProductGenreList(String productGenreCategory, String productSubGenreCategory);
    ResponseDto<ProductGetResponseDto> getProduct(int productSeq);

}
