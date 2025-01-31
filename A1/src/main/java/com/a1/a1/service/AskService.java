package com.a1.a1.service;

import com.a1.a1.dto.request.ask.AskPatchRequestDto;
import com.a1.a1.dto.request.ask.AskPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.ask.*;

import java.util.List;

public interface AskService {
    ResponseDto<AskPostResponseDto> postAsk(AskPostRequestDto dto, String userId);
    ResponseDto<List<AskGetListResponseDto>> getAskAllByAskWriter(String userId);
    ResponseDto<AskGetAskIdResponseDto> getAskId(int askId);
//    ResponseDto<AskPatchResponseDto> patchAsk(AskPatchRequestDto dto);
    ResponseDto<Boolean> deleteByAskId(int askId);
    ResponseDto<AskGetFindResponseDto> findByAskWriterAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(String userId, int askStatus, int months, int askSort);
//
//    // 문의 삭제
//    ResponseDto<Boolean> deleteByAskId(int askId);
}