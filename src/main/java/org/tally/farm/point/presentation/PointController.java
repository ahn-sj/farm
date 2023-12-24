package org.tally.farm.point.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tally.farm.point.application.PointService;

import static org.tally.farm.point.dto.PointRequest.*;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @PostMapping("/v1/point-charge")
    public ResponseEntity<Void> insertPoint(@RequestBody PointCreate request) {
        pointService.earnPoint(request);
        return ResponseEntity.ok().build();
    }

}
