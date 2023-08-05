package com.example.wantedbackend.module.Member.service;

import com.example.wantedbackend.module.Member.controller.dto.request.SigninRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.request.SignupRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SigninResponseDTO;
import com.example.wantedbackend.module.Member.controller.dto.response.SignupResponseDTO;
import com.example.wantedbackend.module.Member.domain.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class MemberServiceTest {

    @Autowired
    private MemberService service;

    @Mock
    private MemberRepository repository;

    @Test
    @DisplayName("회원가입에 성공할 것이다.")
    void signupTest() {

        // given
        String account = "service@naver.com";
        String password = "qwer1234!";

        SignupRequestDTO dto = new SignupRequestDTO(account, password);

        // when
        SignupResponseDTO result = service.signup(dto);

        // then
        assertTrue(result.isSignup());

    }

    @Test
    @DisplayName("로그인에 성공할 것이다.")
    void signinTest() {

        // given
        String account = "login@naver.com";
        String password = "qwer1234!";

        SigninRequestDTO signinRequest = new SigninRequestDTO(account, password);
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO(account, password);

        SignupResponseDTO signup = service.signup(signupRequestDTO);

        // when
        SigninResponseDTO result = service.signin(signinRequest);

        // then
        assertTrue(result.isSignin());

    }

}
