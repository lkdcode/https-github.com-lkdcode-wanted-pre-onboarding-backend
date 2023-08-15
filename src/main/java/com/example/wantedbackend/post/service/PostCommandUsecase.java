package com.example.wantedbackend.post.service;

import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateRequestDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostDeleteResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostUpdateResponseDTO;

public interface PostCommandUsecase {

    PostCreateResponseDTO create(PostCreateRequestDTO dto);

    PostDeleteResponseDTO delete(Long id);

    PostUpdateResponseDTO update(Long id);

}
