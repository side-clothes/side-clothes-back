package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.request.product.ProductLikePostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.product.*;
import com.a1.a1.entity.ProductEntity;
import com.a1.a1.repository.ProductRepository;
import com.a1.a1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // 좋아요 누르기
    public ResponseDto<ProductLikePostResponseDto> postProductLike(ProductLikePostRequestDto dto) {

        ProductLikePostResponseDto data = null;
        int productSeq = dto.getProductId();

        try {

            ProductEntity productEntity = productRepository.findByProductId(productSeq);
            productEntity.setProductLike(productEntity.getProductLike() + 1);

            productRepository.save(productEntity);

            data = new ProductLikePostResponseDto(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    // 제품명으로 제품 찾기
    public ResponseDto<ProductSearchGetResponseDto> getProductSearch(String productTitle) {
        System.out.println(productTitle);
        ProductSearchGetResponseDto data = null;

        try {

            List<ProductEntity> productList = productRepository.findByProductNameContaining(productTitle);

            data = new ProductSearchGetResponseDto(productList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    // 좋아요 top 10 조회
    public ResponseDto<BestSellerGetResponseDto> getBestSeller() {

        BestSellerGetResponseDto data = null;

        try {

            List<ProductEntity> bestSellerList = productRepository.findTop10ByOrderByProductLikeDesc();

            data = new BestSellerGetResponseDto(bestSellerList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    // 제품 젠체 조회
    public ResponseDto<RandomProductImageGetResponseDto> getRandomProductImage(){

        RandomProductImageGetResponseDto data = null;
        try {

            List<ProductEntity> randomProductImageList = productRepository.findAll();

            data = new RandomProductImageGetResponseDto(randomProductImageList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // Id로 제품 조회
    public ResponseDto<ProductDetailGetProductSeqResponseDto> getProductDetailPage(int productId){

        ProductDetailGetProductSeqResponseDto data = null;

        try {

            ProductEntity productEntity = productRepository.findByProductId(productId);

            data = new ProductDetailGetProductSeqResponseDto(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

}