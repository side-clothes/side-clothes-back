package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.product.ProductLikePostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.product.*;
import com.a1.a1.repository.ProductRepository;
import com.a1.a1.service.implement.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiMappingPattern.PRODUCT)
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProductRepository productRepository;

    private static final String POST_PRODUCT_LIKE = "/productLike";
    private static final String PRODUCT_GET_FIND = "/findProduct/{productTitle}";
    private static final String GET_BEST_SELLER = "/bestSeller";
    private static final String GET_RANDOM_PRODUCT = "/randomProduct";
    private static final String GET_PRODUCT_DETAIL_PRODUCTSEQ = "/productDetail/{productSeq}";

    @PostMapping(POST_PRODUCT_LIKE)
    public ResponseDto<ProductLikePostResponseDto> postPoductLike(@Valid @RequestBody ProductLikePostRequestDto requestBody){
        ResponseDto<ProductLikePostResponseDto> LikePage = productService.postPoductLike(requestBody);
        return LikePage;
    }

    @GetMapping(PRODUCT_GET_FIND)
    public ResponseDto<ProductSearchGetResponseDto> getProductSearch(@PathVariable("productTitle") String productTitle) {
        ResponseDto<ProductSearchGetResponseDto> result
                = productService.getProductSearch(productTitle);
        return result;
    }

    @GetMapping(GET_BEST_SELLER)
    public ResponseDto<BestSellerGetResponseDto> getBestSeller(){
        ResponseDto<BestSellerGetResponseDto> response = productService.getBestSeller();
        return response;
    }

    @GetMapping(GET_RANDOM_PRODUCT)
    public ResponseDto<RandomProductImageGetResponseDto> getRandomProductImage(){
        ResponseDto<RandomProductImageGetResponseDto> response
                = productService.getRandomProductImage();
        return response;
    }

    @GetMapping(GET_PRODUCT_DETAIL_PRODUCTSEQ)
    public ResponseDto<ProductDetailGetProductSeqResponseDto> getProductDetailPage(@PathVariable("productSeq") int productSeq){
        ResponseDto<ProductDetailGetProductSeqResponseDto> response
                = productService.getProductDetailPage(productSeq);
        return response;
    }

}