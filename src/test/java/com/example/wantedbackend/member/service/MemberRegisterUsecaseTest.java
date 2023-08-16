package com.example.wantedbackend.member.service;

import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSigninRequestDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSigninResponseDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSignupRequestDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSignupResponseDTO;
import com.example.wantedbackend.member.exception.AuthenticationException;
import com.example.wantedbackend.support.BaseServiceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MemberRegisterUsecaseTest extends BaseServiceTest {

    @Autowired
    MemberRegisterUsecase memberRegisterUsecase;

    @Test
    void 회원가입_성공() {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";
        MemberSignupRequestDTO dto = new MemberSignupRequestDTO(name, email, password);

        // when
        MemberSignupResponseDTO signup = memberRegisterUsecase.signup(dto);

        // then
        Assertions.assertThat(signup.success()).isTrue();
    }

    @Test
    void 회원가입_실패() {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";
        MemberSignupRequestDTO alreadySignedup = new MemberSignupRequestDTO(name, email, password);

        String newName = "name";
        String newEmail = "test@naver.com";
        String newPassword = "12345678";
        MemberSignupRequestDTO newSignup = new MemberSignupRequestDTO(newName, newEmail, newPassword);

        // when
        memberRegisterUsecase.signup(alreadySignedup);

        // then
        Assertions.assertThatExceptionOfType(AuthenticationException.class)
                .isThrownBy(() -> memberRegisterUsecase.signup(newSignup));
    }

    @Test
    void 로그인_성공() {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";
        MemberSignupRequestDTO dto = new MemberSignupRequestDTO(name, email, password);
        memberRegisterUsecase.signup(dto);

        MemberSigninRequestDTO signinRequestDTO = new MemberSigninRequestDTO(email, password);

        // when
        MemberSigninResponseDTO signin = memberRegisterUsecase.signin(signinRequestDTO);

        // then
        Assertions.assertThat(signin.token()).isNotBlank();
    }

    @Test
    void 로그인_실패_이메일_틀림() {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";
        MemberSignupRequestDTO dto = new MemberSignupRequestDTO(name, email, password);
        memberRegisterUsecase.signup(dto);

        String newEmail = "testtest@naver.com";

        MemberSigninRequestDTO signinRequestDTO = new MemberSigninRequestDTO(newEmail, password);

        // when
        // then
        Assertions.assertThatExceptionOfType(AuthenticationException.class)
                .isThrownBy(() -> memberRegisterUsecase.signin(signinRequestDTO));
    }

    @Test
    void 로그인_실패_비밀번호_틀림() {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";
        MemberSignupRequestDTO dto = new MemberSignupRequestDTO(name, email, password);
        memberRegisterUsecase.signup(dto);

        String newPassword = "123123123";

        MemberSigninRequestDTO signinRequestDTO = new MemberSigninRequestDTO(email, newPassword);

        // when
        // then
        Assertions.assertThatExceptionOfType(AuthenticationException.class)
                .isThrownBy(() -> memberRegisterUsecase.signin(signinRequestDTO));
    }

}