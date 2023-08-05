package com.example.wantedbackend.global.exception.handler;

import com.example.wantedbackend.global.exception.custom.CustomException;
import com.example.wantedbackend.global.exception.custom.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> exception(ErrorCode erroCode) {
        log.error("CustomException : Status : {} ,message : {}", erroCode.getHttpStatus(), erroCode.getMessage());
        return ResponseEntity.status(erroCode.getHttpStatus()).body(erroCode.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validException(ErrorCode erroCode) {
        log.error("CustomException : Status : {} ,message : {}", erroCode.getHttpStatus(), erroCode.getMessage());
        return ResponseEntity.status(erroCode.getHttpStatus()).body(erroCode.getMessage());
    }
}
