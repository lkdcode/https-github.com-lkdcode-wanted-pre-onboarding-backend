package com.example.wantedbackend.post.service;

import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.member.repository.MemberRepository;
import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostFindAllResponseDTO;
import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostResponseDTO;
import com.example.wantedbackend.post.domain.Post;
import com.example.wantedbackend.post.exception.PostException;
import com.example.wantedbackend.post.repository.PostQueryRepository;
import com.example.wantedbackend.support.BaseServiceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.*;

class PostQueryUsecaseTest extends BaseServiceTest {

    @Autowired
    PostQueryUsecase postQueryUsecase;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostQueryRepository postQueryRepository;

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
    void 게시글_전체_조회_성공() {
        // given
        int pageSize = 5;
        int pageNumber = 0;
        Pageable pageable = PageRequest.of(
                pageNumber,
                pageSize,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        // when
        PostFindAllResponseDTO responseDTO = postQueryUsecase.findAll(pageable);

        // then
        System.out.println(responseDTO.list().get(0).id() + " <<<<<<<<<<<");
        Assertions.assertThat(responseDTO.list().get(0).title()).isEqualTo("test title49");
    }

    @Test
    void 아이디로_게시글_조회_성공() {
        // given
        Long id = 13L;

        // when
        PostResponseDTO postResponseDTO = postQueryUsecase.findById(id);

        // then
        Assertions.assertThat(postResponseDTO.title()).isEqualTo("test title12");
    }

    @Test
    void 아이디로_게시글_조회_실패() {
        // given
        Long id = -1L;
        // when
        // then
        Assertions.assertThatExceptionOfType(PostException.class)
                .isThrownBy(() -> postQueryUsecase.findById(id));
    }

}
