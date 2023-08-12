package com.example.wantedbackend.module.Post.controller.dto.response;

import com.example.wantedbackend.module.Post.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PostFindResponseDTO {

    private Long idx;
    private String title;
    private String content;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

    public static PostFindResponseDTO toDTO(Post entity) {
        return PostFindResponseDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createDt(entity.getCreateDt())
                .updateDt(entity.getUpdateDt())
                .build();
    }

}
