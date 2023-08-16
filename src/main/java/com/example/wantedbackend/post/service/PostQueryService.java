package com.example.wantedbackend.post.service;

import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostFindAllResponseDTO;
import com.example.wantedbackend.post.api.dto.PostQueryDTO.PostResponseDTO;
import com.example.wantedbackend.post.domain.Post;
import com.example.wantedbackend.post.exception.PostErrorCode;
import com.example.wantedbackend.post.exception.PostException;
import com.example.wantedbackend.post.repository.PostQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUsecase {

    private final PostQueryRepository postQueryRepository;

    @Override
    public PostFindAllResponseDTO findAll(final Pageable pageable) {
        Page<Post> foundList = postQueryRepository.findAll(pageable);

        List<PostResponseDTO> collect =
                foundList.stream().map(e -> PostResponseDTO.builder()
                                .id(e.getId())
                                .title(e.getTitle())
                                .content(e.getContent())
                                .name(e.getMember().getName())
                                .createdAt(e.getCreatedAt())
                                .updatedAt(e.getUpdatedAt())
                                .build())
                        .collect(Collectors.toList());

        long lastPageNumber = foundList.getTotalPages();

        if (pageable.getPageNumber() >= lastPageNumber) {
            throw new PostException(PostErrorCode.PAGE_OUT_OF_RANGE);
        }

        return PostFindAllResponseDTO.builder()
                .list(collect)
                .build();
    }

    @Override
    public PostResponseDTO findById(Long id) {
        Post foundPost = postQueryRepository.findById(id)
                .orElseThrow(PostErrorCode.NOT_FOUNT_POST::defaultException);

        return PostResponseDTO.builder()
                .id(foundPost.getId())
                .name(foundPost.getMember().getName())
                .title(foundPost.getTitle())
                .content(foundPost.getTitle())
                .createdAt(foundPost.getCreatedAt())
                .updatedAt(foundPost.getUpdatedAt())
                .build();
    }

}
