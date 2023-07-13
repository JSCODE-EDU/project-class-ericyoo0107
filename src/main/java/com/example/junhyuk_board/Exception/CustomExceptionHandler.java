package com.example.junhyuk_board.Exception;

import com.example.junhyuk_board.Exception.Customs.NoPostError;
import com.example.junhyuk_board.Exception.Customs.UnableFormError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UnableFormError.class)
    public ResponseEntity<ErrorAnswer> HandleUnableFormError(CustomException e) {
        log.error("잘못된 형식의 값을 넣었어요");
        ErrorAnswer errorAnswer = new ErrorAnswer(e.getHttpStatus(), e.getMessage());
        return new ResponseEntity<>(errorAnswer, e.getHttpStatus());
    }

    @ExceptionHandler(NoPostError.class)
    public ResponseEntity<ErrorAnswer> HandleNoPostError(CustomException e) {
        log.error("없는 post 찾으려고 했어요");
        ErrorAnswer errorAnswer = new ErrorAnswer(e.getHttpStatus(), e.getMessage());
        return new ResponseEntity<>(errorAnswer, e.getHttpStatus());
    }

}
