package org.tally.farm.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class DateUtilsTest {

    @Test
    @DisplayName("포인트 만료 정책은 획득일자 +1년 익달이다.")
    void getPointExpireDt() {
        // given
        final LocalDate earnPointDate = LocalDate.of(2023, 12, 24);

        // when
        final LocalDateTime expireDt = DateUtils.getPointExpireDt(earnPointDate);

        // then
        final LocalDateTime except = LocalDateTime.of(2025, 1, 1, 0, 0, 0);
        assertThat(expireDt).isEqualTo(except);
    }

}