package com.example.wantedbackend.module.Post.domain.repository;

import com.example.wantedbackend.module.Member.domain.Member;
import com.example.wantedbackend.module.Post.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class PostRepositoryTest {

    @Autowired
    private PostRepository repository;

    @BeforeEach
    void init() {
        for (int i = 0; i < 50; i++) {
            Post build = Post.builder()
                    .title("title" + (i + 1))
                    .content("content" + (i + 1))
                    .member(Member.builder()
                            .idx((long) (i + 1))
                            .build())
                    .build();
            repository.save(build);
        }
    }


    @Test
    @DisplayName("게시글 저장에 성공할 것이다.")
    void saveTest() {
        // given
        Post build = Post.builder()
                .title("title")
                .content("content")
                .member(Member.builder()
                        .idx(70L)
                        .build())
                .build();

        repository.save(build);

        // when

        // then
    }

    @Test
    @DisplayName("페이지네이션된 모든 게시물 조회 역순에 성공할 것이다.")
    void findAllPagePostsTest() {
        // given
        int page = 1;
        int size = 15;

        // when
        Sort idx = Sort.by("idx");

        PageRequest pageableimpl = PageRequest.of(page - 1, size, idx.descending());

        Page<Post> foundList = repository.findAll(pageableimpl);

        // then
        assertEquals(foundList.stream().count(), size);
    }

    @Test
    @DisplayName("게시글의 ID로 조회에 성공할 것이다.")
    void findByIdTest() {
        // given
        Long idx = 53L;

        // when
        Post byId = repository.findById(idx).orElseThrow();

        // then
        assertEquals(idx, byId.getIdx());

    }

    @Test
    @DisplayName("게시글의 ID로 수정에 성공할 것이다.")
    void updateTest() {
        // given
        Long idx = 53L;
        String updateTitle = "updateTitle";
        String updateContent = "updateContent";

        // when
        Post post = repository.findById(idx).orElseThrow();

        // then
        Post updatePost = Post.builder()
                .idx(post.getIdx())
                .title(updateTitle)
                .content(updateContent)
                .member(post.getMember())
                .build();

        Post save = repository.save(updatePost);

        assertEquals(save.getContent(), updatePost.getContent());
        assertEquals(save.getTitle(), updatePost.getTitle());
        assertEquals(save.getMember(), updatePost.getMember());
    }

    @Test
    @DisplayName("게시글의 ID로 삭제에 성공할 것이다.")
    void deleteTest() {
        // given
        Long idx = 53L;

        // when
        repository.deleteById(idx);

        // then
        Optional<Post> deletedPost = repository.findById(idx);
        assertTrue(deletedPost.isEmpty());
    }

}
