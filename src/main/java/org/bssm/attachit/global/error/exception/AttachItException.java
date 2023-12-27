package org.bssm.attachit.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AttachItException extends RuntimeException {
    private final ErrorCode errorCode;
}
