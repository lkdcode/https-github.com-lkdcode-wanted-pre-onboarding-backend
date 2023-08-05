package com.example.wantedbackend.module.Member.controller;

import com.example.wantedbackend.global.common.ApplicationResponse;
import com.example.wantedbackend.module.Member.controller.dto.request.SigninRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.request.SignupRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SigninResponseDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SignupResponseDTO;
import com.example.wantedbackend.module.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ApplicationResponse<SignupResponseDTO> signup(@RequestBody @Valid SignupRequestDTO dto) {
        SignupResponseDTO signup = memberService.signup(dto);
        return ApplicationResponse.of(signup);
    }

    @PostMapping("/signin")
    public ApplicationResponse<SigninResponseDTO> signin(@RequestBody @Valid SigninRequestDTO dto) {
        SigninResponseDTO signin = memberService.signin(dto);
        return ApplicationResponse.of(signin);
    }

}
