package com.mong.mmbs.dto.response.product;

import java.util.List;

import com.mong.mmbs.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BestSellerGetResponseDto {
  
  List<ProductEntity> bestSellerList;

}
