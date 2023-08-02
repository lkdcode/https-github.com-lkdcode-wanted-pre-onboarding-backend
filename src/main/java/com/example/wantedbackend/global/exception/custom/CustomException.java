package com.example.wantedbackend.global.exception.custom;

import lombok.Getter;

public class CustomException extends RuntimeException {

    @Getter
    private final ErrorCode errocode;

    public CustomException(ErrorCode errocode) {
        super(errocode.getMessage());
        this.errocode = errocode;
    }

}
