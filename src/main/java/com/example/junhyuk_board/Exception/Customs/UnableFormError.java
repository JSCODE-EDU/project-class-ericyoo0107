package com.example.junhyuk_board.Exception.Customs;

import com.example.junhyuk_board.Exception.CustomException;
import com.example.junhyuk_board.Exception.ErrorCodes;

public class UnableFormError extends CustomException {
    public UnableFormError(ErrorCodes errorCodes) {
        super(errorCodes);
    }
}
