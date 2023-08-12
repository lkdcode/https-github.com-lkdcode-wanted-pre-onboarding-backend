package com.example.wantedbackend.module.Post.service;

import com.example.wantedbackend.module.Post.controller.dto.request.PostCreateRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.request.PostDeleteRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.request.PostUpdateRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostCreateResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostDeleteResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostFindResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostUpdateResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class PostServiceTest {
    @Autowired
    private PostService service;

    @Test
    @DisplayName("전체 목록 조회에 성공할 것이다.")
    void getListTest() {
        // givne
        Integer page = 1;

        // when
        List<PostFindResponseDTO> list = service.getList(page);

        // then
        assertEquals(list.size(), 10);
    }

    @Test
    @DisplayName("게시글 id 로 조회에 성공할 것이다.")
    void getByIdTest() {
        // givne
        Long id = 57L;

        // when
        PostFindResponseDTO dto = service.getById(id);

        // then
        assertEquals(dto.getIdx(), id);
    }

    @Test
    @DisplayName("게시글 작성에 성공할 것이다.")
    void createTest() {
        // givne
        String testTitle = "test Title";
        String testContent = "test Content";
        Long memberIdx = 3L;
        PostCreateRequestDTO dto = new PostCreateRequestDTO(testTitle, testContent, memberIdx);

        // when
        PostCreateResponseDTO postCreateResponseDTO = service.create(dto);

        // then
        assertTrue(postCreateResponseDTO.getIsCreate());
    }

    @Test
    @DisplayName("게시글 id 로 수정에 성공할 것이다.")
    void updateTest() {
        // givne
        Long idx = 53L;
        String newTitle = "new Title";
        String newContent = "new Content";
        PostUpdateRequestDTO dto = new PostUpdateRequestDTO(idx, newTitle, newContent);

        // when
        PostUpdateResponseDTO response = service.update(dto);

        // then
        assertEquals(dto.getContent(), response.getUdpateContent());
        assertEquals(dto.getTitle(), response.getUdpateTitle());
    }

    @Test
    @DisplayName("게시글 id 로 삭제에 성공할 것이다.")
    void deleteTest() {
        // givne
        Long idx = 53L;
        PostDeleteRequestDTO request = new PostDeleteRequestDTO(idx);

        // when
        PostDeleteResponseDTO response = service.delete(request);

        // then
        assertTrue(response.getIsDelete());
    }

}