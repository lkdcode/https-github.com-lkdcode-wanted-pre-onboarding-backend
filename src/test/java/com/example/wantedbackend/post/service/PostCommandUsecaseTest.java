package com.example.wantedbackend.post.service;

import com.example.wantedbackend.config.security.CustomUserDetails;
import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.member.exception.AuthenticationException;
import com.example.wantedbackend.member.repository.MemberRepository;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.*;
import com.example.wantedbackend.post.domain.Post;
import com.example.wantedbackend.post.exception.PostException;
import com.example.wantedbackend.post.repository.PostCommandRepository;
import com.example.wantedbackend.support.BaseServiceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PostCommandUsecaseTest extends BaseServiceTest {

    @Autowired
    PostCommandUsecase postCommandUsecase;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PostCommandRepository postCommandRepository;

    private final Member member = new Member("name", "email@naver.com", "12345678", MemberStatus.CREATED);

    @BeforeEach
    void init() {
        memberRepository.save(member);
        for (int i = 0; i < 10; i++) {
            postCommandRepository.save(new Post("test title", "test content", member));
        }
    }

    @AfterEach
    void clear() {
        postCommandUsecase = null;
        postCommandRepository = null;
        memberRepository = null;
    }

    @Test
    void 게시글_작성_성공() {
        // given
        PostCreateRequestDTO dto = new PostCreateRequestDTO("test Title", "test content");
        CustomUserDetails customUserDetails = new CustomUserDetails(member.getId());
        // when
        PostCreateResponseDTO postCreateResponseDTO = postCommandUsecase.create(dto, customUserDetails);

        // then
        Assertions.assertThat(postCreateResponseDTO.success()).isTrue();
    }

    @Test
    void 게시글_작성_실패() {
        // given
        PostCreateRequestDTO dto = new PostCreateRequestDTO("test Title", "test content");
        CustomUserDetails customUserDetails = new CustomUserDetails(-1L);
        // when
        // then
        Assertions.assertThatExceptionOfType(AuthenticationException.class)
                .isThrownBy(() -> postCommandUsecase.create(dto, customUserDetails));
    }

    @Test
    void 게시글_삭제_성공() {
        // given
        Long postId = 1L;
        CustomUserDetails customUserDetails = new CustomUserDetails(member.getId());

        // when
        PostDeleteResponseDTO delete = postCommandUsecase.delete(postId, customUserDetails);

        // then
        Assertions.assertThat(delete.success()).isTrue();
    }

    @Test
    void 게시글_삭제_실패() {
        // given
        Long postId = 8L;
        CustomUserDetails customUserDetails = new CustomUserDetails(3L);

        // when
        // then
        Assertions.assertThatExceptionOfType(PostException.class)
                .isThrownBy(() -> postCommandUsecase.delete(postId, customUserDetails));
    }

//    @Test
//    void 게시글_수정_성공() {
//        // given
//        Long postId = 4L;
//        CustomUserDetails customUserDetails = new CustomUserDetails(member.getId());
//        PostUpdateRequestDTO dto = new PostUpdateRequestDTO(postId, "update title", "update content");
//
//        // when
//        PostUpdateResponseDTO update = postCommandUsecase.update(dto, customUserDetails);
//
//        // then
//        Assertions.assertThat(update.success()).isTrue();
//    }

    @Test
    void 게시글_수정_실패() {
        // given
        Long postId = 1L;
        CustomUserDetails customUserDetails = new CustomUserDetails(3L);
        PostUpdateRequestDTO dto = new PostUpdateRequestDTO(postId, "update title", "update content");

        // when
        // then
        Assertions.assertThatExceptionOfType(PostException.class)
                .isThrownBy(() -> postCommandUsecase.update(dto, customUserDetails));
    }

}