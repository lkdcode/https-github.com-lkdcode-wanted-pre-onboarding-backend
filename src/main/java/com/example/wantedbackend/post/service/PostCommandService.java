package com.example.wantedbackend.post.service;

import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateRequestDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostDeleteResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCommandService implements PostCommandUsecase {
    @Override
    public PostCreateResponseDTO create(PostCreateRequestDTO dto) {
        return null;
    }

    @Override
    public PostDeleteResponseDTO delete(Long id) {
        return null;
    }

    @Override
    public PostUpdateResponseDTO update(Long id) {
        return null;
    }
}
