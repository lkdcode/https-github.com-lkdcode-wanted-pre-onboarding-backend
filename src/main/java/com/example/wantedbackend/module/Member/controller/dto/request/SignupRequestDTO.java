package com.example.wantedbackend.module.Member.controller.dto.request;


import com.example.wantedbackend.module.Member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDTO {

    @Email
    private String account;

    @NotBlank
    @Length(min = 8)
    private String password;

}
