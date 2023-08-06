package com.example.wantedbackend.module.Post.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDeleteRequestDTO {

    @NotBlank
    private Long idx;

}
