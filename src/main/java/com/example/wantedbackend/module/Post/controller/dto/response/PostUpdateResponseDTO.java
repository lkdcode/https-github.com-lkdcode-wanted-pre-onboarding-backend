package com.example.wantedbackend.module.Post.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostUpdateResponseDTO {
    private String udpateTitle;
    private String udpateContent;

}
