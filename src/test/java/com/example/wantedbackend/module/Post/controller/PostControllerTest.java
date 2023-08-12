package com.example.wantedbackend.module.Post.controller;

import com.example.wantedbackend.module.Member.controller.MemberController;
import com.example.wantedbackend.module.Member.domain.Member;
import com.example.wantedbackend.module.Post.controller.dto.request.PostCreateRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostCreateResponseDTO;
import com.example.wantedbackend.module.Post.domain.Post;
import com.example.wantedbackend.module.Post.domain.repository.PostRepository;
import com.example.wantedbackend.module.Post.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MemberController controller;
    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setup() {
        // 테스트 데이터 추가
        Post post = Post.builder()
                .title("Test Post")
                .content("This is a test post.")
                .member(Member.builder()
                        .idx(50L)
                        .build())
                .build();
        postRepository.save(post);
    }


    @Test
    @DisplayName("전체 게시글 조회에 성공할 것이다.")
    void findAllTest() throws Exception {
        // given
        Integer page = 1;

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/list/" + page)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload").isArray())
                .andDo(print());

    }

    @Test
    @DisplayName("특정 게시글 조회에 성공할 것이다.")
    void findByIdTest() throws Exception {
        // given

        Post post = Post.builder()
                .title("Test Post")
                .content("This is a test post.")
                .member(Member.builder()
                        .idx(51L)
                        .build())
                .build();
        postRepository.save(post);
        Long idx = post.getIdx();
        // when
        // then

        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/list/detail/" + idx)
                        .contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload.idx").value(idx))
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload.title").value(post.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload.content").value(post.getContent()))
                .andDo(print());

    }

    @Test
    @DisplayName("게시글 작성에 성공할 것이다.")
    void createTest() throws Exception {
        // given
        String title = "test Title";
        String content = "test Content";

        Long memberIdx = 13L;

        PostCreateRequestDTO request = new PostCreateRequestDTO(title, content, memberIdx);

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload.isCreate").value(true))
                .andDo(print())
        ;
    }

    @Test
    @DisplayName("게시글 수정에 성공할 것이다.")
    void updateTest() {
        // given
        // when
        // then
    }

    @Test
    @DisplayName("게시글 삭제에 성공할 것이다.")
    void deleteTest() {
        // given
        // when
        // then
    }

}
