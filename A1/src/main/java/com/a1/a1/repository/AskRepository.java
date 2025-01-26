package com.a1.a1.repository;

import com.a1.a1.entity.AskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AskRepository extends JpaRepository<AskEntity, Integer> {

//  public List<AskEntity> findByAskWriter(String UserId);


//    List<AskEntity> findByAskId(int askId);
//
    List<AskEntity> findByAskWriter(String UserId);

    AskEntity findByAskId(int askId);

    void deleteByAskId(int askId);
//
    Optional<AskEntity> findByAskWriterAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(String userId, String askDatetime,int askStatus, int askSort);

//  List<AskEntity> findByAskId(String askId);
}