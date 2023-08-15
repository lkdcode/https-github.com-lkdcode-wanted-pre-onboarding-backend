package com.example.wantedbackend.post.api;

import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostFindAllResponseDTO;
import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostResponseDTO;
import com.example.wantedbackend.post.service.PostQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RestController
@RequiredArgsConstructor
public class PostQueryApi extends PostApi {

    private PostQueryUsecase postQueryUsecase;

    @GetMapping("/list")
    public PostFindAllResponseDTO findAll(
            @PageableDefault(size = 5,
                    sort = "createdAt",
                    direction = DESC
            ) Pageable pageable
    ) {
        return postQueryUsecase.findAll(pageable);
    }

    @GetMapping("/{id}")
    public PostResponseDTO findById(@PathVariable(name = "id") Long id) {
        return postQueryUsecase.findById(id);
    }

}
