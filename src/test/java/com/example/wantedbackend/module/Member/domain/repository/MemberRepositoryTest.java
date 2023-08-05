package com.example.wantedbackend.module.Member.domain.repository;

import com.example.wantedbackend.module.Member.controller.dto.request.SignupRequestDTO;
import com.example.wantedbackend.module.Member.controller.mapper.MemberMapper;
import com.example.wantedbackend.module.Member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("tb_member 테이블에 데이터 저장에 성공할 것이다.")
    void saveTest() {
        // given
        String account = "test@naver.com";
        String password = "qwer1234!";

        Member member = Member.builder()
                .account(account)
                .password(password)
                .build();

        // when
        Member saved = memberRepository.save(member);

        // then
        assertEquals(account, saved.getAccount());
    }

    @Test
    @DisplayName("tb_member 테이블에 account 로 회원을 찾을 수 있다.")
    void findByAccountTest() {
        // given
        String account = "test@naver.com";
        String password = "qwer1234!";

        Member member = Member.builder()
                .account(account)
                .password(password)
                .build();

        // when
        Member saved = memberRepository.save(member);
        Member member1 = memberRepository.findByAccount(account).orElseThrow();

        // then
        assertEquals(account, saved.getAccount());
        assertEquals(saved.getAccount(), member1.getAccount());
    }

}
