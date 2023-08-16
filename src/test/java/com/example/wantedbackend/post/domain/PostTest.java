package com.example.wantedbackend.post.domain;

import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostTest {

    @Test
    public void 게시글_생성_성공() {
        // given
        String title = "test title";
        String content = "test content";
        Member member = new Member("testName", "test@naver.com", "12345678", MemberStatus.CREATED);

        Post post = new Post(title, content, member);

        // when
        // then
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getMember()).isEqualTo(member);
    }

}