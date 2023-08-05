package com.example.wantedbackend.module.Member.controller.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SigninRequestDTO {

    @Email
    private String account;

    @NotBlank
    @Length(min = 8)
    private String password;

}
