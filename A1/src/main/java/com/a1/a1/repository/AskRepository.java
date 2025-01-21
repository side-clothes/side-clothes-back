package com.a1.a1.repository;

import com.a1.a1.entity.AskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskRepository extends JpaRepository<AskEntity, Integer> {

    List<AskEntity> findByAskWriter(String UserId);

    AskEntity findByAskId(int askId);

    AskEntity deleteByAskId(int askId);

    List<AskEntity> findByAskWriterAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(String userId, String askDatetime,int askStatus, int askSort);

}