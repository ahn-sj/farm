package org.tally.farm.point.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tally.farm.point.dto.PointRequest;
import org.tally.farm.user.application.validator.UserValidator;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointReader pointReader;
    private final PointWriter pointWriter;

    private final UserValidator userValidator;

    public void earnPoint(final PointRequest.PointCreate request) {
        userValidator.validateNotExisted(request.userId());

        final int currentPoint = pointReader.getCurrnetPoint(request.userId());
        pointWriter.earnPoint(request, currentPoint);
    }
}
