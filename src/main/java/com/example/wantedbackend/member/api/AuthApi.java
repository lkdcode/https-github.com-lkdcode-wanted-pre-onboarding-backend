package com.example.wantedbackend.member.api;

import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.*;
import com.example.wantedbackend.member.service.MemberRegisterUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class AuthApi {

    private final MemberRegisterUsecase memberRegisterUsecase;

    @PostMapping("/signup")
    public MemberSignupResponseDTO singup(
            @RequestBody @Valid MemberSignupRequestDTO dto
    ) {
        return memberRegisterUsecase.signup(dto);
    }

    @PostMapping("/signin")
    public MemberSigninResponseDTO singin(
            @RequestBody @Valid MemberSigninRequestDTO dto
    ) {
        return memberRegisterUsecase.signin(dto);
    }

}
