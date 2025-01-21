package com.a1.a1.repository;

import com.a1.a1.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity, Integer> {

    GiftEntity findByGiftCode(int giftCode);

}