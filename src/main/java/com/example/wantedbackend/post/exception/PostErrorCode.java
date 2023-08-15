package com.example.wantedbackend.post.exception;

import com.example.wantedbackend.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum PostErrorCode implements ErrorCode {

    NOT_FOUNT_POST("해당 게시글은 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
    PAGE_OUT_OF_RANGE("페이지 정보가 유효하지 않습니다.", HttpStatus.BAD_REQUEST),
    CANNOT_DELETE_OTHERS_POST("본인 글이 아니면 삭제할 수 없습니다.", HttpStatus.FORBIDDEN),
    CANNOT_UPDATE_OTHERS_POST("본인 글이 아니면 수정할 수 없습니다.", HttpStatus.FORBIDDEN);


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
    public PostException defaultException() {
        return new PostException(this);
    }

    @Override
    public PostException defaultException(Throwable cause) {
        return new PostException(this, cause);
    }

}
