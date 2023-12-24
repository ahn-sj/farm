package org.tally.farm.point.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tally.farm.point.domain.PointStatus;
import org.tally.farm.point.domain.entity.PointChargeType;
import org.tally.farm.point.domain.entity.PointDetail;
import org.tally.farm.point.domain.entity.PointEvent;
import org.tally.farm.point.domain.repository.PointDetailJpaRepository;
import org.tally.farm.point.domain.repository.PointEventJpaRepository;
import org.tally.farm.utils.DateUtils;

import java.time.LocalDateTime;

import static org.tally.farm.point.dto.PointRequest.PointCreate;

@Service
@RequiredArgsConstructor
public class PointWriter {

    private final PointReader pointReader;
    private final PointEventJpaRepository pointEventJpaRepository;
    private final PointDetailJpaRepository pointDetailJpaRepository;

    @Transactional
    public void earnPoint(final PointCreate request, final PointChargeType type) {
        final int currnetPoint = pointReader.getCurrnetPoint(request.userId());

        final LocalDateTime expireDt = DateUtils.getPointExpireDt();

        final PointEvent pointEvent = PointEvent.builder()
                .userId(type.getId())
                .status(PointStatus.CHARGE)
                .amount(type.getAmount())
                .balance(type.getBalanceAfterSumChargeAmount(currnetPoint))
                .expireDt(expireDt)
                .build();
        final PointEvent savedEvent = pointEventJpaRepository.save(pointEvent);

        final PointDetail pointDetail = PointDetail.builder()
                .pointEventId(savedEvent.getId())
                .amount(type.getAmount())
                .status(PointStatus.CHARGE)
                .expireDt(expireDt)
                .build();
        pointDetailJpaRepository.save(pointDetail);
    }
}
