package com.example.wantedbackend.member.service;

import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.*;

public interface MemberRegisterUsecase {

    MemberSignupResponseDTO signup(MemberSignupRequestDTO dto);
    MemberSigninResponseDTO signin(MemberSigninRequestDTO dto);

}
