package org.tally.farm.point.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointStatus {

    CHARGE("충전"),
    INCOME("적립"),
    OUTGO("사용"),
    EXPIRE("유효기간만료")
    ;

    private final String description;
}
