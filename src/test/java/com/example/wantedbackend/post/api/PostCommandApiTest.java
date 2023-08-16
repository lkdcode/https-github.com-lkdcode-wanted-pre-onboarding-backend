package com.example.wantedbackend.post.api;

import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.member.repository.MemberRepository;
import com.example.wantedbackend.post.api.dto.PostCommandDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateRequestDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostUpdateRequestDTO;
import com.example.wantedbackend.post.domain.Post;
import com.example.wantedbackend.post.repository.PostCommandRepository;
import com.example.wantedbackend.post.service.PostCommandUsecase;
import com.example.wantedbackend.support.BaseApiTest;
import com.example.wantedbackend.util.jwt.JwtProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

class PostCommandApiTest extends BaseApiTest {

    @Autowired
    private PostCommandUsecase postCommandUsecase;
    @Autowired
    private PostCommandRepository postCommandRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private JwtProvider jwtProvider;
    private final Member member = new Member("name", "email@naver.com", "12345678", MemberStatus.CREATED);

    @BeforeEach
    void init() {
        memberRepository.save(member);

        for (int i = 0; i < 10; i++) {
            postCommandRepository.save(new Post("title", "content", member));
        }
    }

    @Test
    void 글_작성_요청_성공() throws Exception {
        //given
        PostCreateRequestDTO dto = new PostCreateRequestDTO("test title", "test content");
        String token = jwtProvider.createToken(member.getId());

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/posts")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
        ).andExpectAll(MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.success").value(true));
    }

    @Test
    void 글_작성_요청_실패() throws Exception {
        //given
        PostCreateRequestDTO dto = new PostCreateRequestDTO("test title", "test content");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/posts")
                        .header("Authorization", "Bearer ")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
        ).andExpectAll(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void 글_삭제_요청_성공() throws Exception {
        //given
        String token = jwtProvider.createToken(member.getId());
        Long postId = 1L;

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/posts/{id}", postId)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.success").value(true));
    }

    @Test
    void 글_삭제_요청_실패() throws Exception {
        //given
        String token = jwtProvider.createToken(member.getId());
        Long postId = -1L;

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/posts/{id}", postId)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void 글_수정_요청_성공() throws Exception {
        //given
        Long postId = 1L;
        PostUpdateRequestDTO dto = new PostUpdateRequestDTO(postId, "update title", "update content");
        String token = jwtProvider.createToken(member.getId());

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/posts")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
        ).andExpectAll(MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.success").value(true));
    }

}