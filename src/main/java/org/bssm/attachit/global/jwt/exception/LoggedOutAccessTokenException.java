package org.bssm.attachit.global.jwt.exception;

import org.bssm.attachit.global.error.exception.AttachItException;
import org.bssm.attachit.global.error.exception.ErrorCode;

public class LoggedOutAccessTokenException extends AttachItException {
    public static final LoggedOutAccessTokenException EXCEPTION = new LoggedOutAccessTokenException(ErrorCode.LOGGED_OUT_TOKEN);
    public LoggedOutAccessTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
