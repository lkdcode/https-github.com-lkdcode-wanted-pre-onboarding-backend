package com.example.wantedbackend.post.api.dto;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Builder
    public record PostCreateResponseDTO(Boolean success) {
    }

    @Builder
    public record PostDeleteResponseDTO(Boolean success) {
    }

    public record PostUpdateRequestDTO(
            @NotNull
            Long postId,
            @NotBlank
            @Length(max = 50)
            String updateTitle,
            @NotBlank
            @Length(max = 2000)
            String updateContent
    ) {
    }

    @Builder
    public record PostUpdateResponseDTO(Boolean success) {
    }

}
