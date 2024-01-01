package org.tally.farm.point.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tally.farm.point.domain.entity.PointChargeType;
import org.tally.farm.point.domain.repository.PointChargeTypeJpaRepository;
import org.tally.farm.point.domain.repository.PointEventJpaRepository;

import static org.tally.farm.global.exception.ErrorCode.POINT_TYPE_NOT_FOUND;
import static org.tally.farm.point.exception.PointException.PointChargeTypeNotFoundException;

@Service
@RequiredArgsConstructor
public class PointReader {

    private static final int ZERO_POINT = 0;

    private final PointChargeTypeJpaRepository pointChargeTypeJpaRepository;
    private final PointEventJpaRepository pointEventJpaRepository;

    public PointChargeType getPointChargeType(final Long pointChargeTypeId) {
        return pointChargeTypeJpaRepository.findById(pointChargeTypeId).orElseThrow(
                () -> new PointChargeTypeNotFoundException(POINT_TYPE_NOT_FOUND, pointChargeTypeId));
    }

    public int getCurrnetPoint(final Long userId) {
        final Long currentPoint = pointEventJpaRepository.findCurrentPoint(userId);

        if(currentPoint == null) {
            return ZERO_POINT;
        }
        return currentPoint.intValue();
    }
}
