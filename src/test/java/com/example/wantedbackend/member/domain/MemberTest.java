package com.example.wantedbackend.member.domain;

import com.example.wantedbackend.member.domain.type.MemberStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {
    @Test
    public void 멤버_생성_성공() {
        // given
        // when
        Member member = new Member("testName", "test@naver.com", "12345678", MemberStatus.CREATED);

        // then
        assertThat(member.getEmail()).isEqualTo("test@naver.com");
        assertThat(member.getPassword()).isEqualTo("12345678");
        assertThat(member.getName()).isEqualTo("testName");
        assertThat(member.getStatus()).isEqualTo(MemberStatus.CREATED);
    }

}