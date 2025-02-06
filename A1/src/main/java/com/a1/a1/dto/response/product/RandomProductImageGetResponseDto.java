package com.a1.a1.dto.response.product;

import com.a1.a1.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RandomProductImageGetResponseDto {

    List<ProductEntity> randomProductImageList;

}