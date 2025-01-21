package com.a1.a1.service;

import com.a1.a1.dto.request.ask.AskPatchRequestDto;
import com.a1.a1.dto.request.ask.AskPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.ask.*;

public interface AskService {
    ResponseDto<AskPostResponseDto> post(AskPostRequestDto dto, String userId);
    ResponseDto<AskGetListResponseDto> getList(String userId);
    ResponseDto<AskGetAskIdResponseDto> get(int askId);
    ResponseDto<AskPatchResponseDto> patch(AskPatchRequestDto dto);
    ResponseDto<AskDeleteResponseDto> delete(String userId, int askId);
}