package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.product.ProductLikePostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.product.*;
import com.a1.a1.repository.ProductRepository;
import com.a1.a1.service.implement.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private static final String GET_PRODUCT_DETAIL_PRODUCTSEQ = "/productDetail/{productId}";

    // 좋아요 누르기
    @PostMapping(POST_PRODUCT_LIKE)
    public ResponseEntity<ResponseDto<ProductLikePostResponseDto>> postProductLike(@Valid @RequestBody ProductLikePostRequestDto requestBody){
        ResponseDto<ProductLikePostResponseDto> result = productService.postProductLike(requestBody);
        HttpStatus status = result.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(result);
    }

    // 제품명으로 제품 찾기
    @GetMapping(PRODUCT_GET_FIND)
    public ResponseEntity<ResponseDto<ProductSearchGetResponseDto>> getProductSearch(@PathVariable("productTitle") String productTitle) {
        ResponseDto<ProductSearchGetResponseDto> result = productService.getProductSearch(productTitle);
        HttpStatus status = result.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(result);
    }

    // 좋아요 top10 조회
    @GetMapping(GET_BEST_SELLER)
    public ResponseEntity<ResponseDto<BestSellerGetResponseDto>> getBestSeller(){
        ResponseDto<BestSellerGetResponseDto> response = productService.getBestSeller();
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

    // 제품 전체 조회
    @GetMapping(GET_RANDOM_PRODUCT)
    public ResponseEntity<ResponseDto<RandomProductImageGetResponseDto>> getRandomProductImage(){
        ResponseDto<RandomProductImageGetResponseDto> response = productService.getRandomProductImage();
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

    // Id로 제품 조회
    @GetMapping(GET_PRODUCT_DETAIL_PRODUCTSEQ)
    public ResponseEntity<ResponseDto<ProductDetailGetProductSeqResponseDto>> getProductDetailPage(@PathVariable("productId") int productId){
        ResponseDto<ProductDetailGetProductSeqResponseDto> response = productService.getProductDetailPage(productId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

}