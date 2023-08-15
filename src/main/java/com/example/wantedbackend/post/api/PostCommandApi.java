package com.example.wantedbackend.post.api;

import com.example.wantedbackend.config.security.CustomUserDetails;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateRequestDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostDeleteResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostUpdateResponseDTO;
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
        System.out.println(userDetails);
        System.out.println(userDetails.getId());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());

        System.out.println("create");
        return null;
    }

    @PutMapping("/{id}")
    public PostUpdateResponseDTO update(
            @PathVariable(name = "id") Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        System.out.println(userDetails);
        System.out.println(userDetails.getId());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());

        System.out.println("update");
        return null;
    }

    @DeleteMapping("/{id}")
    public PostDeleteResponseDTO delete(
            @PathVariable(name = "id") Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        System.out.println(userDetails);
        System.out.println(userDetails.getId());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());

        System.out.println("delete");
        return null;
    }

}
