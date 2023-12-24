package org.tally.farm.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST("1001", HttpStatus.BAD_REQUEST),
    NOT_FOUND("1002", HttpStatus.BAD_REQUEST)

    ;


    private final String errorCode;
    private final HttpStatus status;
}
