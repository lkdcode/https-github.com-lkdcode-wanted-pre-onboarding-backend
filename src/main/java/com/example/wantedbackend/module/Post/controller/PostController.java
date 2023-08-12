package com.example.wantedbackend.module.Post.controller;

import com.example.wantedbackend.global.common.ApplicationResponse;
import com.example.wantedbackend.module.Post.controller.dto.request.PostCreateRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.request.PostDeleteRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.request.PostUpdateRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostCreateResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostDeleteResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostFindResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostUpdateResponseDTO;
import com.example.wantedbackend.module.Post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list/{page}")
    public ApplicationResponse<List<PostFindResponseDTO>> findAll(@PathVariable(name = "page") Integer page) {
        List<PostFindResponseDTO> response = postService.getList(page);

        return ApplicationResponse.of(response);
    }

    @GetMapping("/list/detail/{idx}")
    public ApplicationResponse<PostFindResponseDTO> findById(@PathVariable(name = "idx") Long idx) {
        PostFindResponseDTO response = postService.getById(idx);

        return ApplicationResponse.of(response);
    }

    @PostMapping
    public ApplicationResponse<PostCreateResponseDTO> create(@RequestBody final PostCreateRequestDTO dto) {
        PostCreateResponseDTO response = postService.create(dto);

        return ApplicationResponse.of(response);
    }

    @PatchMapping
    public ApplicationResponse<PostUpdateResponseDTO> update(@RequestBody final PostUpdateRequestDTO dto) {
        PostUpdateResponseDTO response = postService.update(dto);

        return ApplicationResponse.of(response);
    }

    @DeleteMapping
    public ApplicationResponse<PostDeleteResponseDTO> delete(@RequestBody final PostDeleteRequestDTO dto) {
        PostDeleteResponseDTO response = postService.delete(dto);

        return ApplicationResponse.of(response);
    }

}
