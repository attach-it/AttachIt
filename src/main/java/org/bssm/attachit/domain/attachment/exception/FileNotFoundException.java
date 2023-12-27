package org.bssm.attachit.domain.attachment.exception;

import org.bssm.attachit.global.error.exception.AttachItException;
import org.bssm.attachit.global.error.exception.ErrorCode;

public class FileNotFoundException extends AttachItException {
    public static final FileNotFoundException EXCEPTION = new FileNotFoundException(ErrorCode.FILE_NOT_FOUND);
    public FileNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
