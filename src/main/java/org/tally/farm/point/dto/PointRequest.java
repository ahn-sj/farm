package org.tally.farm.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PointRequest {

    public record PointCreate(
            @Schema(description = "포인트 충전할 유형", nullable = false, example = "3") Long pointChargeTypeId,
            @Schema(description = "포인트 충전할 사용자 ID", nullable = false, example = "12") Long userId) {}

}
