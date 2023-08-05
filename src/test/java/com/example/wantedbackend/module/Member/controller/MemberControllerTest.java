package com.example.wantedbackend.module.Member.controller;

import com.example.wantedbackend.module.Member.controller.dto.request.SigninRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.request.SignupRequestDTO;
import com.example.wantedbackend.module.Member.domain.Member;
import com.example.wantedbackend.module.Member.domain.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Transactional
@Rollback
@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberController controller;

    @BeforeEach
    void init() {
        final String account = "controller@naver.com";
        final String password = "qwer1234!";

        SignupRequestDTO dto = new SignupRequestDTO(account, password);


        controller.signup(dto);
    }


    @Test
    @DisplayName("memberController 회원가입에 성공할 것이다.")
    void signupTest() throws Exception {
        String account = "signup@naver.com";
        String password = "qwer1234!";
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO(account, password);

        mockMvc.perform(MockMvcRequestBuilders.post("/members/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signupRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload.isSignup").value(true))
                .andDo(print());
    }

    @Test
    @DisplayName("memberController 로그인에 성공할 것이다.")
    void signinTest() throws Exception {
        final String account = "controller@naver.com";
        final String password = "qwer1234!";

        SigninRequestDTO requestDTO = new SigninRequestDTO(account, password);

        mockMvc.perform(MockMvcRequestBuilders.post("/members/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload.isSignin").value(true))
                .andDo(print());
    }
}