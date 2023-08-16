package com.example.wantedbackend.member.repository;


import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.member.exception.AuthenticationErrorCode;
import com.example.wantedbackend.support.BaseRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MemberRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 이메일_중복_검사__이메일이_중복() {
        // given
        String email = "email@naver.com";

        // when
        memberRepository.save(new Member("name", "email@naver.com", "12345678", MemberStatus.CREATED));

        boolean exists = memberRepository.existsMemberByEmail(email);
        // then

        assertThat(exists).isTrue();
    }

    @Test
    void 이메일_중복_검사__이메일이_미중복() {
        // given
        String email = "email@naver.com";
        // when
        boolean exists = memberRepository.existsMemberByEmail(email);
        // then
        assertThat(exists).isFalse();
    }


    @Test
    void 이메일로_멤버_조회_성공() {
        // given
        String email = "email@naver.com";
        String name = "name";

        // when
        memberRepository.save(new Member("name", "email@naver.com", "12345678", MemberStatus.CREATED));

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(AuthenticationErrorCode.MISMATCHED::defaultException);
        // then

        assertThat(member.getEmail()).isEqualTo(email);
        assertThat(member.getName()).isEqualTo(name);
    }

    @Test
    void 이메일로_멤버_조회_실패() {
        // given
        String email = "email@naver.com";
        // when
        // then

        assertThatExceptionOfType(AuthenticationErrorCode.MISMATCHED.defaultException().getClass())
                .isThrownBy(() -> memberRepository.findByEmail(email)
                        .orElseThrow(AuthenticationErrorCode.MISMATCHED::defaultException));
    }

}
