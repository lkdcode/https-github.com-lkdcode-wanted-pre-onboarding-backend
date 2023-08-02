package com.example.wantedbackend.global.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_EMAIL_FORMAT(HttpStatus.BAD_REQUEST, "아이디(이메일)는 이메일 형식으로 입력해주세요."),
    INVALID_PASSWORD_LENGTH(HttpStatus.BAD_REQUEST, "비밀번호는 8자리 이상입니다."),
    INVALID_CREDENTIALS(HttpStatus.BAD_REQUEST, "아이디 또는 비밀번호가 일치하지 않습니다."),
    UNAUTHORIZED_POST_DELETE(HttpStatus.BAD_REQUEST, "본인 글이 아니면 삭제할 수 없습니다."),
    UNAUTHORIZED_POST_MODIFY(HttpStatus.BAD_REQUEST, "본인 글이 아니면 수정할 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
