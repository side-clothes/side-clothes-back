package com.a1.a1.repository;

import com.a1.a1.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByProductSeq(int productSeq);
    List<ProductEntity> findByProductGenre(String productGenreCategory);
    List<ProductEntity> findByProductGenreAndProductSubGenre(String productGenreCategory, String productSubGenreCategory);

    List<ProductEntity> findTop10ByOrderByProductLikeDesc();

    List<ProductEntity> findByProductNameContaining(String productName);

    @Query(value = "SELECT * FROM product order by RAND() limit 6",nativeQuery = true)
    List<ProductEntity> findAll();

}