package org.tally.farm.point.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tally.farm.point.application.PointService;

import static org.tally.farm.point.dto.PointRequest.PointCreate;

@Tag(name = "01. POINT", description = "POINT API")
@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @PostMapping("/v1/points/point-charge")
    public ResponseEntity<Void> insertPoint(@RequestBody PointCreate request) {
        pointService.earnPoint(request);
        return ResponseEntity.ok().build();
    }

}
