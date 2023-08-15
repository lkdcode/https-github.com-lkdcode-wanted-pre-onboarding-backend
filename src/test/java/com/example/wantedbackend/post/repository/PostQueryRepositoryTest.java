package com.example.wantedbackend.post.repository;

import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.member.repository.MemberRepository;
import com.example.wantedbackend.post.domain.Post;
import com.example.wantedbackend.support.BaseRepositoryTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

class PostQueryRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private PostQueryRepository postQueryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {

        for (int i = 0; i < 50; i++) {
            Member member = new Member("name" + i, i + "email@naver.com", "12345678", MemberStatus.CREATED);
            memberRepository.save(member);
            Post post = new Post("test title" + i, "test content" + i, member);
            postQueryRepository.save(post);
        }

    }

    @Test
    void 게시글_페이지네이션() {
        // given
        int pageSize = 5;
        int pageNumber = 0;
        Pageable pageable = PageRequest.of(
                pageNumber, // Page number, assuming it's 0-based
                pageSize, // Page size
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        // when
        Page<Post> list = postQueryRepository.findAll(pageable);

        // then
        Assertions.assertThat(list.getSize()).isEqualTo(pageSize);
    }

}
