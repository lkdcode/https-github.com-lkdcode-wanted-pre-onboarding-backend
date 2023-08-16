package com.example.wantedbackend.post.api;

import com.example.wantedbackend.config.security.CustomUserDetails;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.*;
import com.example.wantedbackend.post.service.PostCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostCommandApi {

    private final PostCommandUsecase postCommandUsecase;

    @PostMapping
    public PostCreateResponseDTO create(
            @RequestBody @Valid PostCreateRequestDTO dto,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return postCommandUsecase.create(dto, userDetails);
    }

    @DeleteMapping("/{id}")
    public PostDeleteResponseDTO delete(
            @PathVariable(name = "id") Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return postCommandUsecase.delete(id, userDetails);
    }

    @PutMapping
    public PostUpdateResponseDTO update(
            @RequestBody @Valid PostUpdateRequestDTO dto,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return postCommandUsecase.update(dto, userDetails);
    }

}
