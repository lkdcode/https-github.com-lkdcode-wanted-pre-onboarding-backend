package com.example.wantedbackend.member.api;

import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSigninRequestDTO;
import com.example.wantedbackend.member.api.dto.MemberRegisterRequestDTO.MemberSignupRequestDTO;
import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.member.repository.MemberRepository;
import com.example.wantedbackend.member.service.MemberRegisterUsecase;
import com.example.wantedbackend.support.BaseApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class AuthApiTest extends BaseApiTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberRegisterUsecase memberRegisterUsecase;

    @Test
    void 회원가입_요청_성공() throws Exception {
        // given
        MemberSignupRequestDTO signupRequestDTO = new MemberSignupRequestDTO("name", "test@naver.com", "12345678");

        // when
        // then
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/members/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signupRequestDTO))
        ).andExpectAll(MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.success").value(true)
        );

    }

    @Test
    void 회원가입_요청_실패__이메일_중복() throws Exception {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";
        MemberSignupRequestDTO signupRequestDTO = new MemberSignupRequestDTO(name, email, password);
        memberRepository.save(new Member(name, email, password, MemberStatus.CREATED));

        // when
        // then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/members/signup")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(signupRequestDTO))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(MockMvcResultMatchers.status().is4xxClientError(),
                        MockMvcResultMatchers.jsonPath("$").value("중복된 이메일입니다.")
                );

    }

    @Test
    void 로그인_요청_성공() throws Exception {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";

        MemberSignupRequestDTO signupRequestDTO = new MemberSignupRequestDTO(name, email, password);
        memberRegisterUsecase.signup(signupRequestDTO);

        MemberSigninRequestDTO signinRequestDTO = new MemberSigninRequestDTO(email, password);
        // when
        // then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/members/signin")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(signinRequestDTO))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.token").isNotEmpty()
                );
    }

    @Test
    void 로그인_요청_실패() throws Exception {
        // given
        String name = "name";
        String email = "test@naver.com";
        String password = "12345678";

        MemberSignupRequestDTO signupRequestDTO = new MemberSignupRequestDTO(name, email, password);
        memberRegisterUsecase.signup(signupRequestDTO);

        String signinPassword = "123123123";
        MemberSigninRequestDTO signinRequestDTO = new MemberSigninRequestDTO(email, signinPassword);
        // when
        // then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/members/signin")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(signinRequestDTO))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(MockMvcResultMatchers.status().is4xxClientError(),
                        MockMvcResultMatchers.jsonPath("$").value("아이디 혹은 비밀번호가 일치하지 않습니다.")
                );

    }

}
