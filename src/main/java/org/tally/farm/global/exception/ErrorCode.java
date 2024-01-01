package org.tally.farm.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.tally.farm.global.exception.Detail.NOT_FOUND;
import static org.tally.farm.global.exception.Detail.SERVER_ERROR;
import static org.tally.farm.global.exception.Domain.COMMON;
import static org.tally.farm.global.exception.Domain.POINT;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    COMMON_SERVER_ERROR("1000", COMMON, SERVER_ERROR),

    POINT_TYPE_NOT_FOUND("2001", POINT, NOT_FOUND)

    ;

    private final String errorCode;
    private final Domain domain;
    private final Detail detail;
}
