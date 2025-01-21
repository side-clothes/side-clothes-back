package com.a1.a1.dto.response.order;

import com.a1.a1.entity.GiftEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftGetResponseDto {

    List<GiftEntity> giftList;

}