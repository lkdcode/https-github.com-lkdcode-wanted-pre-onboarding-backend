package com.example.wantedbackend.global.exception.custom;

import lombok.Getter;

public class CustomException extends RuntimeException {

    @Getter
    private final ErrorCode errocode;

    public CustomException(ErrorCode errocode) {
        super("meesage");
        this.errocode = errocode;
    }
}
