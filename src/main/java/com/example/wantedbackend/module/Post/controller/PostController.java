package com.example.wantedbackend.module.Post.controller;

import com.example.wantedbackend.global.common.ApplicationResponse;
import com.example.wantedbackend.module.Post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list/{page}")
    public ApplicationResponse<?> findAll() {
        return null;
    }

    @GetMapping("/detail/{idx}")
    public ApplicationResponse<?> findById() {
        return null;
    }

    @PostMapping
    public ApplicationResponse<?> create() {
        return null;
    }

    @PatchMapping
    public ApplicationResponse<?> update() {
        return null;
    }

    @DeleteMapping
    public ApplicationResponse<?> delete() {
        return null;
    }

}
