package com.example.wantedbackend.module.Member.service;

import com.example.wantedbackend.module.Member.controller.dto.request.SigninRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.request.SignupRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SigninResponseDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SignupResponseDTO;
import com.example.wantedbackend.module.Member.domain.Member;
import com.example.wantedbackend.module.Member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.lang.Boolean.*;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    public SignupResponseDTO signup(SignupRequestDTO dto) {
        Member member = Member.builder()
                .account(dto.getAccount())
                .password(encoder.encode(dto.getPassword()))
                .build();
        Member save = memberRepository.save(member);

        return new SignupResponseDTO(save.getAccount().equals(dto.getAccount()));
    }

    public SigninResponseDTO signin(SigninRequestDTO dto) {
        Boolean result = FALSE;
        Member member = memberRepository.findByAccount(dto.getAccount()).orElseThrow();

        if (encoder.matches(dto.getPassword(), member.getPassword())) {
            result = TRUE;
        }

        return new SigninResponseDTO(result);
    }

}
