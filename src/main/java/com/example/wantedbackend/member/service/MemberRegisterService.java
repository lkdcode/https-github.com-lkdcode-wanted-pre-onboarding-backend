package com.example.wantedbackend.member.service;

import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSigninRequestDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSigninResponseDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSignupRequestDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSignupResponseDTO;
import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.member.exception.AuthenticationErrorCode;
import com.example.wantedbackend.member.exception.AuthenticationException;
import com.example.wantedbackend.member.repository.MemberRepository;
import com.example.wantedbackend.member.service.mapper.MemberDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberRegisterService implements MemberRegisterUsecase {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberDTOMapper mapper;

    @Override
    public MemberSignupResponseDTO signup(MemberSignupRequestDTO dto) {

        boolean exists = memberRepository.existsMemberByEmail(dto.email());
        if (exists) throw new AuthenticationException(AuthenticationErrorCode.DUPLICATED_EMAIL);

        String digest = passwordEncoder.encode(dto.rawPassword());

        Member member = mapper.from(
                dto.email()
                , digest
                , dto.name()
                , MemberStatus.CREATED
        );

        memberRepository.save(member);

        return MemberSignupResponseDTO.builder()
                .success(true)
                .build();
    }

    @Override
    public MemberSigninResponseDTO signin(MemberSigninRequestDTO dto) {

        return MemberSigninResponseDTO.builder()
                .token(null)
                .build();
    }

}
