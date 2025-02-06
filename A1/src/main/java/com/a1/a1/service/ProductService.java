package com.a1.a1.service;

import com.a1.a1.dto.request.product.ProductLikePostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.product.*;

public interface ProductService {
    ResponseDto<ProductLikePostResponseDto> postProductLike(ProductLikePostRequestDto dto);
    ResponseDto<ProductSearchGetResponseDto> getProductSearch(String productTitle);
    ResponseDto<BestSellerGetResponseDto> getBestSeller();
    ResponseDto<RandomProductImageGetResponseDto> getRandomProductImage();
    ResponseDto<ProductDetailGetProductSeqResponseDto> getProductDetailPage(int productSeq);


}