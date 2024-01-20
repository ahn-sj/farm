package org.tally.farm.point.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.tally.farm.global.exception.ErrorCode;

import java.util.Arrays;

import static org.tally.farm.point.exception.PointException.PointChargeTypeNotFoundException;

@Getter
@RequiredArgsConstructor
public enum PointChargeType {

    // TODO: 금액권을 어떻게 나타낼지
    POINT_TYPE_01(10_000, "P001", "1만원 충전권", "탈리 팜 포인트를 1만원 충전합니다.");

    private final int amount;
    private final String code;
    private final String name;
    private final String description;

    public static PointChargeType find(final String code) {
        return Arrays.stream(values())
                .filter(chargeType -> chargeType.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new PointChargeTypeNotFoundException(ErrorCode.POINT_NOT_FOUND, code));
    }

    public int getBalanceAfterSumChargeAmount(final int currentPoint) {
        return currentPoint + amount;
    }

}
