package com.a1.a1.entity;

import com.a1.a1.dto.request.ask.AskPatchRequestDto;
import com.a1.a1.dto.request.ask.AskPostRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
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
    private String askWriter;
    //  문의 카테고리 [-1: 제품 문의, 0: 배송 문의, 1: 기타 문의]
    private int askSort;
    // 	문의 제목
    @NotBlank
    private String askTitle;
    //  문의 내용
    @NotBlank
    private String askContent;
    //  문의 날짜
    private String askDatetime;
    //  문의 상태 [-1: 삭제, 0: 문의 접수, 1: 답변완료 상태]
    private int askStatus;
    //  문의 답변
    private String askReply;

    public AskEntity(AskPostRequestDto dto, String userId){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        this.askWriter = userId;
        this.askSort = dto.getAskSort();
        this.askTitle = dto.getAskTitle();
        this.askContent = dto.getAskContent();
        this.askDatetime = dateFormat.format(new Date());
        this.askStatus = 0;
    }

    public void patch(AskPatchRequestDto dto) {
        this.askId = dto.getAskId();
        this.askSort = dto.getAskSort();
        this.askTitle = dto.getAskTitle();
        this.askContent = dto.getAskContent();
    }

}