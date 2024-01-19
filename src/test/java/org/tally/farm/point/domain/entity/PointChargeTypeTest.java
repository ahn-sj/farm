package org.tally.farm.point.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tally.farm.point.domain.PointChargeType;

import static org.assertj.core.api.Assertions.assertThat;

class PointChargeTypeTest {

    @Test
    @DisplayName("포인트 충전 유형에 설정된 값에 현재 포인트를 더한 결과값이 계산 후 잔액이 된다.")
    void getBalanceAfterSumChargeAmount() {

        // given
        final PointChargeType type = PointChargeType.POINT_TYPE_01;

        // when
        final int balance = type.getBalanceAfterSumChargeAmount(5_000);

        // then
        assertThat(15000).isEqualTo(balance);

    }

}