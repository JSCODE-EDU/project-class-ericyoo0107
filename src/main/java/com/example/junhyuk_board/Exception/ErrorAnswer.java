package com.example.junhyuk_board.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorAnswer {
    private HttpStatus httpStatus;
    private String message;
}
