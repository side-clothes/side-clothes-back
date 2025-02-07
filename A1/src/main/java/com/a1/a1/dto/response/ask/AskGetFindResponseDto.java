package com.a1.a1.dto.response.ask;

import com.a1.a1.entity.AskEntity;
import com.a1.a1.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AskGetFindResponseDto {
    private int askId;
    private Long userId;
    private int askSort;
    private String askTitle;
    private String askContent;
    private LocalDateTime askDatetime;
    private int askStatus;
    private String askReply;

    public AskGetFindResponseDto(AskEntity askEntity, Long userId) {
        this.askId = askEntity.getAskId();
        this.userId = userId;
        this.askSort = askEntity.getAskSort();
        this.askTitle = askEntity.getAskTitle();
        this.askContent = askEntity.getAskContent();
        this.askDatetime = askEntity.getAskDatetime();
        this.askStatus = askEntity.getAskStatus();
        this.askReply = askEntity.getAskReply();
    }
}