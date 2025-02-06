package com.a1.a1.service;

import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGenreGetListResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGetResponseDto;
import com.a1.a1.entity.type.Main_category;
import com.a1.a1.entity.type.Recommend_category;

public interface ProductCategoryService {
    ResponseDto<ProductGenreGetListResponseDto> getProductGenreList(Enum<Main_category> mainCategory, Enum<Recommend_category> recommendCategory);
    ResponseDto<ProductGetResponseDto> getProduct(int productSeq);

}
