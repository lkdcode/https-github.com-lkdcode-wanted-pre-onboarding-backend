package com.example.wantedbackend.member.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record MemberRegisterRequestDTO() {

    public record MemberSignupRequestDTO(
            @NotBlank
            @Length(max = 10)
            String name,
            @Email
            @NotBlank
            String email,
            @JsonProperty("password")
            @Pattern(
                    regexp = "^(.{8,})$",
                    message = "비밀번호 양식을 확인해주세요."
            )
            String rawPassword
    ) {
    }

    @Builder
    public record MemberSignupResponseDTO(boolean success) {
    }

    public record MemberSigninRequestDTO(
            @Email
            @NotBlank
            String email,
            @JsonProperty("password")
            @Pattern(
                    regexp = "^(.{8,})$",
                    message = "비밀번호 양식을 확인해주세요."
            )
            String rawPassword
    ) {

    }

    @Builder
    public record MemberSigninResponseDTO(
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            String token
    ) {
    }

}
