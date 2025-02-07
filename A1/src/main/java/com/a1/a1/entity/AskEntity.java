package com.a1.a1.entity;

import com.a1.a1.dto.request.ask.AskPatchRequestDto;
import com.a1.a1.dto.request.ask.AskPostRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "asks")
@Entity(name = "asks")
public class AskEntity {
    //  문의 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ask_id")
    private int askId;

    //  작성자 아이디 (참조)
    @NotBlank
    @Column(name = "id")
    private Long userId;

    //  문의 카테고리 [-1: 제품 문의, 0: 배송 문의, 1: 기타 문의]
    @Column(name = "ask_sort")
    private int askSort;

    // 	문의 제목
    @NotBlank
    @Column(name = "ask_title")
    private String askTitle;

    //  문의 내용
    @NotBlank
    @Column(name = "ask_content")
    private String askContent;

    //  문의 날짜
    @Column(name = "ask_datetime")
    private LocalDateTime askDatetime;

    //  문의 상태 [-1: 삭제, 0: 문의 접수, 1: 답변완료 상태]
    @Column(name = "ask_status")
    private int askStatus;

    //  문의 답변
    @Column(name = "ask_reply")
    private String askReply;

    public AskEntity(AskPostRequestDto dto, UserEntity user) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.userId = user.getId();
        this.askSort = dto.getAskSort();
        this.askTitle = dto.getAskTitle();
        this.askContent = dto.getAskContent();
        this.askStatus = 0;
    }

    public void patch(AskPatchRequestDto dto, UserEntity user) {
        this.askId = dto.getAskId();
        this.userId = user.getId();
        this.askSort = dto.getAskSort();
        this.askTitle = dto.getAskTitle();
        this.askContent = dto.getAskContent();
    }

}