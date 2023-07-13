package com.example.junhyuk_board.Exception.Customs;

import com.example.junhyuk_board.Exception.CustomException;
import com.example.junhyuk_board.Exception.ErrorCodes;

public class NoPostError extends CustomException {
    public NoPostError(ErrorCodes errorCodes) {
        super(errorCodes);
    }
}
