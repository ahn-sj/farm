package org.tally.farm.point.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tally.farm.point.domain.entity.PointChargeType;
import org.tally.farm.point.dto.PointRequest;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointReader pointReader;
    private final PointWriter pointWriter;

    public void earnPoint(final PointRequest.PointCreate request) {
        final PointChargeType type = pointReader.getPointChargeType(request.pointChargeTypeId());

        pointWriter.earnPoint(request, type);
    }
}
