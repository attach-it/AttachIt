package org.bssm.attachit.domain.attachment.exception;

import org.bssm.attachit.global.error.exception.AttachItException;
import org.bssm.attachit.global.error.exception.ErrorCode;

public class FileException extends AttachItException {
    public static final FileException EXCEPTION = new FileException(ErrorCode.FILE_ERROR);
    public FileException(ErrorCode errorCode) {
        super(errorCode);
    }
}
