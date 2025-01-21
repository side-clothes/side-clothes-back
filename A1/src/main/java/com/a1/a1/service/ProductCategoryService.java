package com.a1.a1.service;

import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGenreGetListResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGetResponseDto;

public interface ProductCategoryService {
    ResponseDto<ProductGenreGetListResponseDto> getProductGenreList(String productGenreCategory, String productSubGenreCategory);
    ResponseDto<ProductGetResponseDto> getProduct(int productSeq);

}
