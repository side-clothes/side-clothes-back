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

    public ResponseDto<ProductLikePostResponseDto> postPoductLike(ProductLikePostRequestDto dto) {

        ProductLikePostResponseDto data = null;
        int productSeq = dto.getProductSeq();

        try {

            ProductEntity productEntity = productRepository.findByProductSeq(productSeq);
            productEntity.setProductLike(productEntity.getProductLike() + 1);

            productRepository.save(productEntity);

            data = new ProductLikePostResponseDto(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<ProductSearchGetResponseDto> getProductSearch(String productTitle) {

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

    public ResponseDto<ProductDetailGetProductSeqResponseDto> getProductDetailPage(int productSeq){

        ProductDetailGetProductSeqResponseDto data = null;

        try {

            ProductEntity productEntity = productRepository.findByProductSeq(productSeq);

            data = new ProductDetailGetProductSeqResponseDto(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

}