package com.example.wantedbackend.post.exception;

import com.example.wantedbackend.support.exception.CustomException;
import com.example.wantedbackend.support.exception.ErrorCode;

public class PostException extends CustomException {
    public PostException() {
        super();
    }

    public PostException(String message) {
        super(message);
    }

    public PostException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostException(ErrorCode errorCode) {
        super(errorCode);
    }

    public PostException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

}
