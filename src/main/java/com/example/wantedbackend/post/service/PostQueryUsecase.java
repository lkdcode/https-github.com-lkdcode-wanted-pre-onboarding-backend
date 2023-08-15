package com.example.wantedbackend.post.service;


import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostFindAllResponseDTO;
import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface PostQueryUsecase {

    @Transactional(readOnly = true)
    PostFindAllResponseDTO findAll(Pageable pageable);

    @Transactional(readOnly = true)
    PostResponseDTO findById(Long id);

}
