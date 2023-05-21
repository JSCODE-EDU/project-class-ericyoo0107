package com.example.junhyuk_board.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCodes {

    //400 : 제목-내용을 똑바로 안넣었을때
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "제목이나 내용 알맞게 넣으세요"),
    //404 : 아얘 없는 페이지를 요청했을때
    NOT_FOUND(HttpStatus.NOT_FOUND, "그 페이지 없어요"),
    //500 : 없는 게시물 요청 했을때
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 터졌어요");
    private final HttpStatus httpStatus;
    private final String message;

    ErrorCodes(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
