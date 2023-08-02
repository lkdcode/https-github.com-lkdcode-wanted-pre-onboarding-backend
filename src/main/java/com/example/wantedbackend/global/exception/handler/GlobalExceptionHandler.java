package com.example.wantedbackend.global.exception.handler;

import com.example.wantedbackend.global.exception.custom.CustomException;
import com.example.wantedbackend.global.exception.custom.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> exception(ErrorCode erroCode) {
        return ResponseEntity.status(401).body("message");
    }
}
