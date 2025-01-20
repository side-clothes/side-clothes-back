package com.mong.mmbs.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mong.mmbs.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
    
public ProductEntity findByProductSeq(int productSeq);
public List<ProductEntity> findByProductAge(String productAgeCategory);
public List<ProductEntity> findByProductAgeAndProductSubAge(String productAgeCategory, String productSubAgeCategory);
public List<ProductEntity> findByProductGenre(String productGenreCategory);
public List<ProductEntity> findByProductGenreAndProductSubGenre(String productGenreCategory, String productSubGenreCategory);

public List<ProductEntity> findTop10ByOrderByProductLikeDesc();

public List<ProductEntity> findByProductTitleContaining(String productTitle);

@Query(value = "SELECT * FROM product order by RAND() limit 6",nativeQuery = true)
List<ProductEntity> findAll();

}
