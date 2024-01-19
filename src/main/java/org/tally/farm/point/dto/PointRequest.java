package org.tally.farm.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PointRequest {

    public record PointCreate(
            @Schema(description = "포인트 충전할 유형의 코드", nullable = false, example = "P001") String chargeCode,
            @Schema(description = "포인트 충전할 사용자 ID", nullable = false, example = "12") Long userId) {}

}
