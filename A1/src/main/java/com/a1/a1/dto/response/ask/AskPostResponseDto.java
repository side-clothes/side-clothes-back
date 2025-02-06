package com.a1.a1.dto.response.ask;

import com.a1.a1.entity.AskEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AskPostResponseDto {
    private int askId;
    private String askWriter;
    private int askSort;
    private String askTitle;
    @NotBlank
    private String askContent;
    @NotBlank
    private LocalDateTime askDatetime;
    private int askStatus;
    private String askReply;

    public AskPostResponseDto(AskEntity askEntity){
        this.askId = askEntity.getAskId();
        this.askWriter = askEntity.getAskWriter();
        this.askSort = askEntity.getAskSort();
        this.askTitle = askEntity.getAskTitle();
        this.askContent = askEntity.getAskContent();
        this.askDatetime = askEntity.getAskDatetime();
        this.askStatus = askEntity.getAskStatus();
        this.askReply = askEntity.getAskReply();
    }
}