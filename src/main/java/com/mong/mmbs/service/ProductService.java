package com.mong.mmbs.service;

import com.mong.mmbs.dto.request.product.ProductLikePostRequestDto;
import com.mong.mmbs.dto.response.ResponseDto;
import com.mong.mmbs.dto.response.product.*;

public interface ProductService {
    ResponseDto<ProductLikePostResponseDto> postPoductLike(ProductLikePostRequestDto dto);
    ResponseDto<ProductSearchGetResponseDto> getProductSearch(String productTitle);
    ResponseDto<BestSellerGetResponseDto> getBestSeller();
    ResponseDto<RandomProductImageGetResponseDto> getRandomProductImage();
    ResponseDto<ProductDetailGetProductSeqResponseDto> getProductDetailPage(int productSeq);


}
