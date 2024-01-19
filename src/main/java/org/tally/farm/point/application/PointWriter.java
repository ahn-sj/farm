package org.tally.farm.point.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tally.farm.point.domain.PointChargeType;
import org.tally.farm.point.domain.PointStatus;
import org.tally.farm.point.domain.entity.PointDetail;
import org.tally.farm.point.domain.entity.PointEvent;
import org.tally.farm.point.domain.repository.PointDetailJpaRepository;
import org.tally.farm.point.domain.repository.PointEventJpaRepository;
import org.tally.farm.utils.DateUtils;

import java.time.LocalDate;

import static org.tally.farm.point.dto.PointRequest.PointCreate;

@Service
@RequiredArgsConstructor
public class PointWriter {


    private final PointEventJpaRepository pointEventJpaRepository;
    private final PointDetailJpaRepository pointDetailJpaRepository;

    @Transactional
    public void earnPoint(final PointCreate request, final int currentPoint) {
        final PointChargeType type = PointChargeType.find(request.chargeCode());

        final PointEvent pointEvent = getPointEvent(request.userId(), type, currentPoint);
        final PointEvent savedPointEvent = pointEventJpaRepository.save(pointEvent);
        pointDetailJpaRepository.save(getPointDetail(type, savedPointEvent));
    }

    private static PointDetail getPointDetail(final PointChargeType type, final PointEvent savedEvent) {
        return PointDetail.builder()
                .pointEventId(savedEvent.getId())
                .amount(type.getAmount())
                .status(PointStatus.CHARGE)
                .expireDt(DateUtils.getPointExpireDt(LocalDate.now()))
                .build();
    }

    private static PointEvent getPointEvent(final Long userId, final PointChargeType type, final int currentPoint) {
        return PointEvent.builder()
                .userId(userId)
                .status(PointStatus.CHARGE)
                .amount(type.getAmount())
                .balance(type.getBalanceAfterSumChargeAmount(currentPoint))
                .expireDt(DateUtils.getPointExpireDt(LocalDate.now()))
                .build();
    }
}
