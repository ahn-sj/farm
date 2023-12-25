package org.tally.farm.point.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tally.farm.global.response.ApplicationResponse;
import org.tally.farm.global.swagger.controller.PointController;
import org.tally.farm.point.application.PointService;

import static org.tally.farm.point.dto.PointRequest.PointCreate;

@RestController
@RequiredArgsConstructor
public class PointApiController implements PointController {

    private final PointService pointService;

    @Override
    @PostMapping("/v1/points/point-charge")
    public ApplicationResponse<Void> insertPoint(@RequestBody PointCreate request) {
        pointService.earnPoint(request);
        return ApplicationResponse.created().build();
    }

}
