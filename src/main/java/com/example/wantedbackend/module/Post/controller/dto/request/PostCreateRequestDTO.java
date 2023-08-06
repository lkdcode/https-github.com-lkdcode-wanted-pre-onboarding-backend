package com.example.wantedbackend.module.Post.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequestDTO {

    @NotBlank
    @Length(max = 50)
    private String title;
    @NotBlank
    @Length(max = 2000)
    private String content;

    @NotBlank
    private Long memberIdx;

}
