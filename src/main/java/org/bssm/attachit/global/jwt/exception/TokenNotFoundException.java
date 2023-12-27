package org.bssm.attachit.global.jwt.exception;

import org.bssm.attachit.global.error.exception.AttachItException;
import org.bssm.attachit.global.error.exception.ErrorCode;

public class TokenNotFoundException extends AttachItException {
    public static final TokenNotFoundException EXCEPTION = new TokenNotFoundException(ErrorCode.TOKEN_NOT_FOUND);
    public TokenNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
