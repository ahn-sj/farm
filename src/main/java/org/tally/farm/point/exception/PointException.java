package org.tally.farm.point.exception;

import org.tally.farm.global.exception.BusinessException;
import org.tally.farm.global.exception.ErrorCode;

public class PointException extends BusinessException {

    public PointException(final ErrorCode errorCode, final String message) {
        super(errorCode, message);
    }

    public static class PointChargeTypeNotFoundException extends PointException {
        public PointChargeTypeNotFoundException(final ErrorCode errorCode, final String input) {
            super(errorCode, String.format("포인트 적립 유형이 존재하지 않습니다. - request info { point_charge_type_id = %s }", input));
        }
    }
}
