package com.example.wantedbackend.post.service;

import com.example.wantedbackend.config.security.CustomUserDetails;
import com.example.wantedbackend.post.api.dto.PostCommandDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateRequestDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostCreateResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostDeleteResponseDTO;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.PostUpdateResponseDTO;

public interface PostCommandUsecase {

    PostCreateResponseDTO create(PostCreateRequestDTO dto, CustomUserDetails userDetails);

    PostDeleteResponseDTO delete(Long id, CustomUserDetails userDetails);

    PostUpdateResponseDTO update(PostCommandDTO.PostUpdateRequestDTO dto, CustomUserDetails userDetails);

}
