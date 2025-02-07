package com.a1.a1.repository;

import com.a1.a1.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    OrderEntity findByOrderId(Long orderId);

    List<OrderEntity> findByUserId(Long userId);

}