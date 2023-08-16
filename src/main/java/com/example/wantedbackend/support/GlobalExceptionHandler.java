package com.example.wantedbackend.support;

import com.example.wantedbackend.support.exception.CustomException;
import com.example.wantedbackend.support.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> test(CustomException customException) {
        ErrorCode errorCode = customException.getErrorCode();

        String errorName = errorCode.name();
        int status = errorCode.defaultHttpStatus().value();
        String message = errorCode.defaultMessage();

        log.error("erroCode name : {} , status : {} , message : {}", errorName, status, message);

        return ResponseEntity.status(status).body(message);
    }

}
