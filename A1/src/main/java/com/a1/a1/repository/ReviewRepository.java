package com.a1.a1.repository;

import com.a1.a1.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

}