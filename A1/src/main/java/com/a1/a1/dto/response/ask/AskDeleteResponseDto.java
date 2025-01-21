package com.a1.a1.dto.response.ask;

import com.a1.a1.entity.AskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AskDeleteResponseDto {
    List<AskEntity> askList;
}
