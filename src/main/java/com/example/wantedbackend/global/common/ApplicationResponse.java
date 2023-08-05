package com.example.wantedbackend.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"message", "payload"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationResponse<T> {

    private final static String SUCCESS_MESSAGE = "성공적으로 요청을 불러왔습니다.";
    private T payload;
    private String message;

    private ApplicationResponse(T payload) {
        this.payload = payload;
        this.message = SUCCESS_MESSAGE;
    }

    private ApplicationResponse() {
        this.message = SUCCESS_MESSAGE;
    }

    public static <T> ApplicationResponse<T> of(T payload) {
        return new ApplicationResponse<>(payload);
    }

    public static <T> ApplicationResponse<T> of() {
        return new ApplicationResponse<>();
    }

}
