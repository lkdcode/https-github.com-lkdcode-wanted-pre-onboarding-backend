package com.example.wantedbackend.post.api;

import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateRequestDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostDeleteResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostUpdateResponseDTO;
import com.example.wantedbackend.post.service.PostCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostCommandApi extends PostApi {

    private final PostCommandUsecase postCommandUsecase;

    @PostMapping
    public PostCreateResponseDTO create(
            @RequestBody @Valid PostCreateRequestDTO dto
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public PostUpdateResponseDTO update(
            @PathVariable(name = "id") Long id
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public PostDeleteResponseDTO delete(
            @PathVariable(name = "id") Long id
    ) {
        return null;
    }

}
