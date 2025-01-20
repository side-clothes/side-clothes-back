package com.mong.mmbs.service;

import com.mong.mmbs.dto.request.ask.AskPatchRequestDto;
import com.mong.mmbs.dto.request.ask.AskPostRequestDto;
import com.mong.mmbs.dto.response.ResponseDto;
import com.mong.mmbs.dto.response.ask.*;

public interface AskService {
    ResponseDto<AskPostResponseDto> post(AskPostRequestDto dto, String userId);
    ResponseDto<AskGetListResponseDto> getList(String userId);
    ResponseDto<AskGetAskIdResponseDto> get(int askId);
    ResponseDto<AskPatchResponseDto> patch(AskPatchRequestDto dto);
    ResponseDto<AskDeleteResponseDto> delete(String userId, int askId);
}
