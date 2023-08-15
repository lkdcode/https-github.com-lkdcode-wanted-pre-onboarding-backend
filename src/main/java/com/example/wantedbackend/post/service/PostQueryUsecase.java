package com.example.wantedbackend.post.service;


import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostFindAllResponseDTO;
import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostResponseDTO;
import org.springframework.data.domain.Pageable;

public interface PostQueryUsecase {

    PostFindAllResponseDTO findAll(Pageable pageable);

    PostResponseDTO findById(Long id);

}
