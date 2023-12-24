package org.tally.farm.point.dto;

public class PointRequest {

    public record PointCreate(Long pointChargeTypeId, Long userId) {}

}
