package com.a1.a1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="likes")
@Entity(name="likes")
public class LikeEntity {
    //	좋아요 시퀀스
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeSeq;
    //	좋아요한 제품 아이디
    private int likeProductId;
    //	좋아요한 유저의 아이디
    private String likeUserId;
}