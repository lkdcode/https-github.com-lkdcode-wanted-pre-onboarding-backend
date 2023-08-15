package com.example.wantedbackend.post.api.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public record PostCommandDTO() {

    public record PostCreateRequestDTO(
            @NotBlank
            @Length(max = 50)
            String title,
            @NotBlank
            @Length(max = 2000)
            String content
    ) {
    }

    public record PostCreateResponseDTO(Boolean success) {
    }

    public record PostDeleteResponseDTO(Boolean success) {
    }

    public record PostUpdateResponseDTO(Boolean success) {
    }

}
