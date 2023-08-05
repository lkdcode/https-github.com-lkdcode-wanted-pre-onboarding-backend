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
        System.out.println("hello posts/list/{page}");
        return null;
    }

    @GetMapping("/list/detail/{idx}")
    public ApplicationResponse<?> findById() {
        System.out.println("hello posts/list/detail/{idx}");
        return null;
    }

    @PostMapping
    public ApplicationResponse<?> create() {
        System.out.println("hello posts [ POST ]");
        return null;
    }

    @PatchMapping
    public ApplicationResponse<?> update() {
        System.out.println("hello posts [ PATCH ]");
        return null;
    }

    @DeleteMapping
    public ApplicationResponse<?> delete() {
        System.out.println("hello posts [ DELETE ]");
        return null;
    }

}
