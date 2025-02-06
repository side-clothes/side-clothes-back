package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGenreGetListResponseDto;
import com.a1.a1.dto.response.productCategory.ProductGetResponseDto;
import com.a1.a1.entity.ProductEntity;
import com.a1.a1.entity.type.Main_category;
import com.a1.a1.entity.type.Recommend_category;
import com.a1.a1.repository.ProductRepository;
import com.a1.a1.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductRepository productRepository;



    // 장르별 상품 조회
    public ResponseDto<ProductGenreGetListResponseDto> getProductGenreList(Enum<Main_category> mainCategory, Enum<Recommend_category> recommendCategory) {

        ProductGenreGetListResponseDto data = null;

        List<ProductEntity> productGenreList = null;

        if(recommendCategory.equals("0"))

            try {

                productGenreList = productRepository.findByMainCategory(mainCategory);

                data = new ProductGenreGetListResponseDto(productGenreList);

            }catch (Exception exception) {
                exception.printStackTrace();
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }

        else

            try {

                productGenreList = productRepository.findByMainCategoryAndRecommendCategory(mainCategory, recommendCategory);

                data = new ProductGenreGetListResponseDto(productGenreList);

            }catch (Exception exception) {
                exception.printStackTrace();
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 단건 상품 조회
    public ResponseDto<ProductGetResponseDto> getProduct(int productSeq) {

        ProductGetResponseDto data = null;

        try {

            ProductEntity productEntity = productRepository.findByProductId(productSeq);

            data = new ProductGetResponseDto(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

}
