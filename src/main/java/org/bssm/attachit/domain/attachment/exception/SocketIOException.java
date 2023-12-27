package org.bssm.attachit.domain.attachment.exception;

import org.bssm.attachit.global.error.exception.AttachItException;
import org.bssm.attachit.global.error.exception.ErrorCode;

public class SocketIOException extends AttachItException {
    public static final SocketIOException EXCEPTION = new SocketIOException(ErrorCode.SOCKET_OUTPUT);
    public SocketIOException(ErrorCode errorCode) {
        super(errorCode);
    }
}
