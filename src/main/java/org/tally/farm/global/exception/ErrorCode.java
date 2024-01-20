package org.tally.farm.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.tally.farm.global.exception.Detail.*;
import static org.tally.farm.global.exception.Domain.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 1xxx: COMMON
    COMMON_SERVER_ERROR("1000", COMMON, SERVER_ERROR),

    // 2xxx: USER
    USER_NOT_FOUND("2001", USER, NOT_FOUND),
    USER_EMAIL_EXISTED("2002", USER, EXISTED),

    POINT_CHARGE_TYPE_NOT_FOUND("3001", POINT, NOT_FOUND)

    ;

    private final String errorCode;
    private final Domain domain;
    private final Detail detail;
}
