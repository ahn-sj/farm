package org.tally.farm.point.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tally.farm.point.domain.repository.PointEventJpaRepository;

@Service
@RequiredArgsConstructor
public class PointReader {

    private static final int ZERO_POINT = 0;

    private final PointEventJpaRepository pointEventJpaRepository;

    public int getCurrnetPoint(final Long userId) {
        final Long currentPoint = pointEventJpaRepository.findCurrentPoint(userId);

        if(currentPoint == null) {
            return ZERO_POINT;
        }
        return currentPoint.intValue();
    }
}
