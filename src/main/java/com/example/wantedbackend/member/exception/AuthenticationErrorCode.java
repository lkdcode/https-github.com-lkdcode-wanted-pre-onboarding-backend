package com.example.wantedbackend.member.exception;

import com.example.wantedbackend.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum AuthenticationErrorCode implements ErrorCode {

    DUPLICATED_EMAIL("중복된 이메일입니다.", HttpStatus.BAD_REQUEST),
    SIGNIN_FAIL("아이디 혹은 비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    MISMATCHED("회원 정보가 일치하지 않습니다.", HttpStatus.NOT_FOUND),
    INVALID_TOKENS("올바르지 않은 인증 정보입니다.", HttpStatus.BAD_REQUEST);
    public final String message;
    public final HttpStatus status;

    @Override
    public HttpStatus defaultHttpStatus() {
        return status;
    }

    @Override
    public String defaultMessage() {
        return message;
    }

    @Override
    public AuthenticationException defaultException() {
        return new AuthenticationException(this);
    }

    @Override
    public AuthenticationException defaultException(Throwable cause) {
        return new AuthenticationException(this, cause);
    }

}
