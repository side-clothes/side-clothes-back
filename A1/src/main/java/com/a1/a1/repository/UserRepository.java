package com.a1.a1.repository;

import com.a1.a1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByUserEmail(String userEmail);

    UserEntity findByUserEmail(String userEmail);

    UserEntity findByUserEmailAndUserName(String userEmail, String userName);

    UserEntity findByUserIdAndUserNameAndUserEmail(String userId,String userName,String userEmail);

    UserEntity findByUserId(String UserId);

    boolean existsByUserIdAndUserEmail(String userId, String userEmail);

}