package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.request.ask.AskPatchRequestDto;
import com.a1.a1.dto.request.ask.AskPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.ask.*;
import com.a1.a1.entity.AskEntity;
import com.a1.a1.repository.AskRepository;
import com.a1.a1.service.AskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AskServiceImpl implements AskService {

    private final AskRepository askRepository;


    public ResponseDto<AskPostResponseDto> postAsk(AskPostRequestDto dto, String userId
    ){
        AskPostResponseDto data = null;
        String askWriter = dto.getAskWriter();
        int askSort = dto.getAskSort();
        String askTitle = dto.getAskTitle();
        String askContent = dto.getAskContent();
        try {
            AskEntity askEntity = AskEntity.builder()
                    .askTitle(askTitle)
                    .askContent(askContent)
                    .askSort(askSort)
                    .askWriter(askWriter)
                    .build();
            askRepository.save(askEntity);
            data = new AskPostResponseDto(askEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);

    }

    @Override
    public ResponseDto<List<AskGetListResponseDto>> getAskList(String userId) {
        List<AskGetListResponseDto> data = null;
        try {
            List<AskEntity> askEntities = askRepository.findByAskWriter(userId);
            if(askEntities.isEmpty()){
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }
            data = askEntities.stream().map(AskGetListResponseDto::new)
                    .collect(Collectors.toList());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
    }
//
//
//
//
    public ResponseDto<AskGetFindResponseDto> findByAskWriterAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(String userId, int askStatus, int months, int askSort) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.from(Instant.now().minus(months * 30, ChronoUnit.DAYS));
        String askDateTime = simpleDateFormat.format(date);

        AskGetFindResponseDto data = null;

        try {

            Optional<AskEntity> optionalAskEntity = askRepository.findByAskWriterAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(userId, String.valueOf(askStatus),months,askSort);
            if (optionalAskEntity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }
            AskEntity askEntity = optionalAskEntity.get();
            data = new AskGetFindResponseDto(askEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
//
    // 문의 문의 아이디로 조회
    public ResponseDto<AskGetAskIdResponseDto> getAskId(int askId
    ) {
        AskGetAskIdResponseDto data = null;
        try {
            Optional<AskEntity> optionalAskEntity = askRepository.findById(askId);
            if (optionalAskEntity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }
            AskEntity askEntity = optionalAskEntity.get();
            data = new AskGetAskIdResponseDto(askEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
//
//    @Override
//    public ResponseDto<AskPatchResponseDto> patchAsk(AskPatchRequestDto dto) {
//        AskPatchResponseDto data = null;
//        int askId = dto.getAskId();
//
//        try {
//            AskEntity askEntity = (AskEntity) askRepository.findByAskId(askId);
//            if (askEntity == null) return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//            askEntity.patch(dto);
//            askRepository.save(askEntity);
//
//            data = new AskPatchResponseDto(askEntity);
//        } catch (Exception e){
//            e.printStackTrace();
//            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//        }
//        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
//    }
//
    // 문의 삭제
    @Override
    public ResponseDto<Boolean> deleteByAskId(int askId) {
        try {
            askRepository.deleteByAskId( askId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, true);
    }

}