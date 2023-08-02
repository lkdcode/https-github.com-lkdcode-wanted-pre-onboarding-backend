package com.example.wantedbackend.module.Member.controller;

import com.example.wantedbackend.global.common.ApplicationResponse;
import com.example.wantedbackend.module.Member.controller.dto.request.SigninRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.request.SignupRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SigninResponseDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SignupResponseDTO;
import com.example.wantedbackend.module.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ApplicationResponse<SignupResponseDTO> signup(SignupRequestDTO dto) {
        return null;
    }

    @PostMapping("/signin")
    public ApplicationResponse<SigninResponseDTO> signin(SigninRequestDTO dto) {
        return null;
    }

}
