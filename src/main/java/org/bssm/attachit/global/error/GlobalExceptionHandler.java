package org.bssm.attachit.global.error;

import lombok.extern.slf4j.Slf4j;
import org.bssm.attachit.global.error.exception.ErrorCode;
import org.bssm.attachit.global.error.exception.AttachItException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(AttachItException.class)
    public ResponseEntity<ErrorResponse> handleGlobal(AttachItException e) {
        final ErrorCode errorCode = e.getErrorCode();
        log.error(
                "\n" + "{\n" +
                        "\t\"status\": " + errorCode.getStatus() + '\"' +
                        ",\n\t\"message\": \"" + errorCode.getMessage() + '\"' +
                        "\n}"
        );
        return new ResponseEntity<>(
                new ErrorResponse(
                        errorCode.getStatus(),
                        errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
}
