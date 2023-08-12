package com.example.wantedbackend.module.Post.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateRequestDTO {

    @NotBlank
    private Long idx;
    @NotBlank(message = "제목은 50자 이하의 필수 값입니다.")
    @Length(max = 50)
    private String title;
    @NotBlank(message = "내용은 2000자 이하의 필수 값입니다.")
    @Length(max = 2000)
    private String content;

}
