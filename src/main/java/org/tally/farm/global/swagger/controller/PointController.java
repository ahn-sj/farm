package org.tally.farm.global.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tally.farm.global.response.ApplicationResponse;
import org.tally.farm.point.dto.PointRequest;

@Tag(name = "01. POINT", description = "POINT APIs")
public interface PointController {

    @Operation(summary = "포인트 충전", description = "사용자 포인트를 충전합니다")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "성공",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationResponse.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "요청한 포인트 적립 유형이 존재하지 않습니다.",
                    content = {@Content(schema = @Schema(implementation = ApplicationResponse.class))})
    })
    @PostMapping("/v1/points/point-charge")
    ApplicationResponse<Void> insertPoint(@RequestBody PointRequest.PointCreate request);

}
