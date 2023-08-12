package com.example.wantedbackend.module.Post.service;

import com.example.wantedbackend.module.Member.domain.Member;
import com.example.wantedbackend.module.Post.controller.dto.request.PostCreateRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.request.PostDeleteRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.request.PostUpdateRequestDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostCreateResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostDeleteResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostFindResponseDTO;
import com.example.wantedbackend.module.Post.controller.dto.response.PostUpdateResponseDTO;
import com.example.wantedbackend.module.Post.domain.Post;
import com.example.wantedbackend.module.Post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.transform.ResultTransformer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final int SIZE = 10;

    @Transactional(readOnly = true)
    public List<PostFindResponseDTO> getList(final Integer page) {

        Sort sort = Sort.by("idx");
        PageRequest of = PageRequest.of(page - 1, SIZE, sort.descending());

        Page<Post> foundList = postRepository.findAll(of);


        return foundList.stream()
                .map(PostFindResponseDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostFindResponseDTO getById(final Long idx) {
        Post post = postRepository.findById(idx).orElseThrow(/*게시글없음*/);

        return PostFindResponseDTO.toDTO(post);
    }

    public PostCreateResponseDTO create(final PostCreateRequestDTO dto) {
        Boolean result = FALSE;
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(Member.builder()
                        .idx(dto.getMemberIdx())
                        .build())
                .build();

        Post save = postRepository.save(post);

        if (save.getContent().equals(dto.getContent())) {
            result = TRUE;
        }

        return new PostCreateResponseDTO(result);
    }

    public PostUpdateResponseDTO update(final PostUpdateRequestDTO dto) {
        Long idx = dto.getIdx();
        String updateTitle = dto.getTitle();
        String updateContent = dto.getContent();

        Post foundPost = postRepository.findById(idx).orElseThrow(/*게시글이 없습니다.*/);

        foundPost.updateTitle(updateTitle);
        foundPost.updateContent(updateContent);

        Post save = postRepository.save(foundPost);

        return PostUpdateResponseDTO.builder()
                .udpateTitle(updateTitle)
                .udpateContent(updateContent)
                .build();
    }

    public PostDeleteResponseDTO delete(final PostDeleteRequestDTO dto) {
        Long idx = dto.getIdx();

        postRepository.deleteById(idx);
        Optional<Post> byId = postRepository.findById(idx);
        boolean result = byId.isEmpty();

        return new PostDeleteResponseDTO(result);
    }

}
