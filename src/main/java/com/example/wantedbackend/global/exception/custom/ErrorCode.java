package com.example.wantedbackend.global.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    EXCEPTION(HttpStatus.BAD_REQUEST, "mesasge");

    private final HttpStatus httpStatus;
    private final String message;
}
