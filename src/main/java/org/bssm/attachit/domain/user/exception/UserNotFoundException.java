package org.bssm.attachit.domain.user.exception;

import org.bssm.attachit.global.error.exception.AttachItException;
import org.bssm.attachit.global.error.exception.ErrorCode;

public class UserNotFoundException extends AttachItException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
