package com.a1.a1.repository;

import com.a1.a1.entity.ProductEntity;
import com.a1.a1.entity.type.Main_category;
import com.a1.a1.entity.type.Recommend_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByProductId(int productId);
    List<ProductEntity> findByMainCategory(Enum<Main_category> mainCategory);
    List<ProductEntity> findByMainCategoryAndRecommendCategory(Enum<Main_category> mainCategory, Enum<Recommend_category> recommendCategory);

    List<ProductEntity> findTop10ByOrderByProductLikeDesc();

    List<ProductEntity> findByProductNameContaining(String productName);

    @Query(value = "SELECT * FROM products order by RAND() limit 6",nativeQuery = true)
    List<ProductEntity> findAll();

}