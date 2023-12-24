package org.tally.farm.point.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tally.farm.point.domain.entity.PointChargeType;
import org.tally.farm.point.domain.repository.PointEventJpaRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.tally.farm.point.dto.PointRequest.PointCreate;

@SpringBootTest
class PointWriterTest {

    @Autowired
    protected PointWriter pointWriter;

    @Autowired
    protected PointEventJpaRepository pointEventJpaRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("포인트를 적립합니다.")
    void earnPoint() {
        // given
        final PointChargeType type = PointChargeType.builder()
                .id(999L)
                .amount(10_000)
                .name("1만원 충전권")
                .description("탈리 팜 포인트를 1만원 충전합니다.")
                .build();
        final PointCreate request = new PointCreate(type.getId(), 999L);

        // when
        pointWriter.earnPoint(request, type);

        // then
        final Long currentPoint = pointEventJpaRepository.findCurrentPoint(999L);
        assertThat(currentPoint).isEqualTo(10_000);
    }

}