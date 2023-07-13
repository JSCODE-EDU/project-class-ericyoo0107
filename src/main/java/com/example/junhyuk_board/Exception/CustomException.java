package com.example.junhyuk_board.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public CustomException(ErrorCodes errorCodes) {
        this.httpStatus = errorCodes.getHttpStatus();
        this.message = errorCodes.getMessage();
    }

}
