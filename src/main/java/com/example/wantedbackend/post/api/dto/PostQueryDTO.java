package com.example.wantedbackend.post.api.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

public record PostQueryDTO() {

    @Builder
    public record PostFindAllResponseDTO(List<PostResponseDTO> list) {
    }

    @Builder
    public record PostResponseDTO(
            Long id,
            String title,
            String content,
            String name,
            Instant createdAt,
            Instant updatedAt
    ) {
    }

}
