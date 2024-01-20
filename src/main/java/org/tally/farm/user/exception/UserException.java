package org.tally.farm.user.exception;

import org.tally.farm.global.exception.BusinessException;
import org.tally.farm.global.exception.ErrorCode;

public class UserException extends BusinessException {


    public UserException(final ErrorCode errorCode, final String message) {
        super(errorCode, message);
    }

    public static class UserNotFoundException extends UserException {
        public UserNotFoundException(final ErrorCode errorCode, final Long input) {
            super(errorCode, String.format("존재하지 않는 사용자입니다. - request info { user_id = %s }", input));
        }
    }

}
