package com.a1.a1.controller;

import com.a1.a1.common.constant.ApiMappingPattern;
import com.a1.a1.dto.request.ask.AskPatchRequestDto;
import com.a1.a1.dto.request.ask.AskPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.ask.*;
import com.a1.a1.service.AskService;
import com.a1.a1.service.implement.AskServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiMappingPattern.ASK)
public class AskController {


    public final AskService askService;

    public static final String ASK_POST = "/";

    public static final String ASK_GET_LIST = "/list";
    public static final String ASK_GET_FIND = "/{askStatus}/{months}/{askSort}";
    public static final String ASK_GET_ASKID = "/get/{askId}";

    public static final String ASK_PUT = "/";

    public static final String ASK_DELETE_ASKID = "/{askId}";

    // 문의 생성 - 0
    @PostMapping(ASK_POST)
    public ResponseEntity<ResponseDto<AskPostResponseDto>> postAsk(@Valid @RequestBody AskPostRequestDto dto, @AuthenticationPrincipal String userId) {
        ResponseDto<AskPostResponseDto> response = askService.postAsk(dto, userId);
        HttpStatus status = response.isResult() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    // 문의 전체 조회 - 0
    @GetMapping(ASK_GET_LIST)
    public ResponseEntity<ResponseDto<List<AskGetListResponseDto>>> getAskAllByAskWriter(@AuthenticationPrincipal String userId
    ){
        ResponseDto<List<AskGetListResponseDto>> response = askService.getAskAllByAskWriter(userId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

     //문의 검색 - x
    @GetMapping(ASK_GET_FIND)
    public ResponseEntity<ResponseDto<AskGetFindResponseDto>> findByAskWriterAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(@AuthenticationPrincipal String userId, @PathVariable int askStatus, @PathVariable  int months, @PathVariable int askSort) {
        ResponseDto<AskGetFindResponseDto> response = askService.findByAskWriterAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(userId, askStatus, months, askSort);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    // 문의 문의 아이디로 조회 - 0
    @GetMapping(ASK_GET_ASKID)
    public ResponseEntity<ResponseDto<AskGetAskIdResponseDto>> getAskId(@PathVariable int askId) {
        ResponseDto<AskGetAskIdResponseDto> response = askService.getAskId(askId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

   //  문의 수정 - x
//    @PutMapping(ASK_PUT)
//    public ResponseEntity<ResponseDto<AskPatchResponseDto>> patchAsk(@Valid @RequestBody AskPatchRequestDto dto) {
//        ResponseDto<AskPatchResponseDto> response = askService.patchAsk(dto);
//        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
//        return  ResponseEntity.status(status).body(response);
//    }

    // 문의 문의 아이디로 삭제 - 0
    @DeleteMapping(ASK_DELETE_ASKID)
    public ResponseEntity<ResponseDto<Boolean>> deleteByAskId( @PathVariable int askId) {
        ResponseDto<Boolean> response = askService.deleteByAskId(askId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}