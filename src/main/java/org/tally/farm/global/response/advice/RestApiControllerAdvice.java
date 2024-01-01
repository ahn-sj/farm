package org.tally.farm.global.response.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.tally.farm.global.exception.BusinessException;
import org.tally.farm.global.response.ApplicationResponse;

import static org.tally.farm.global.exception.ErrorCode.COMMON_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class RestApiControllerAdvice {

    /**
     * 예외 상황 - 500 처리
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApplicationResponse<Void> handlerException(Exception e) {
//        final StackTraceElement[] stackTraceElements = e.getStackTrace();
//        log.error(e.getClass().getSimpleName(), stackTraceElements[0]);

        log.error("[Common] {}", e.getClass().getSimpleName());
        e.printStackTrace();

        return ApplicationResponse.fail(COMMON_SERVER_ERROR.getErrorCode(), null).build();
    }

    /**
     * 비즈니스 로직상 에러 상황 - 200 처리
     * (예측 가능한 예외)
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public ApplicationResponse<Void> handler(BusinessException e) {
        log.error("[{}] <ErrorCode>: {}, <ErrorMessage>: {}", e.getClass().getSimpleName(), e.getErrorCode(), e.getMessage());
        e.printStackTrace();

        return ApplicationResponse.fail(e.getErrorCode(), e.getMessage()).build();
    }
}
