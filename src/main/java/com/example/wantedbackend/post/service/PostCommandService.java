package com.example.wantedbackend.post.service;

import com.example.wantedbackend.config.security.CustomUserDetails;
import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.exception.AuthenticationErrorCode;
import com.example.wantedbackend.member.repository.MemberRepository;
import com.example.wantedbackend.post.api.dto.PostCommandDTO.*;
import com.example.wantedbackend.post.domain.Post;
import com.example.wantedbackend.post.exception.PostErrorCode;
import com.example.wantedbackend.post.exception.PostException;
import com.example.wantedbackend.post.repository.PostCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class PostCommandService implements PostCommandUsecase {

    private final PostCommandRepository postCommandRepository;
    private final MemberRepository memberRepository;

    @Override
    public PostCreateResponseDTO create(PostCreateRequestDTO dto, CustomUserDetails userDetails) {
        Member member = findMemberByToken(userDetails);

        Post post = Post.builder()
                .title(dto.title())
                .content(dto.content())
                .member(member)
                .build();

        postCommandRepository.save(post);

        return PostCreateResponseDTO.builder()
                .success(TRUE)
                .build();
    }

    @Override
    public PostDeleteResponseDTO delete(Long id, CustomUserDetails userDetails) {
        Post post = findPostById(id);

        verifyPostOwnership(post, userDetails, PostErrorCode.CANNOT_DELETE_OTHERS_POST);

        postCommandRepository.delete(post);

        return PostDeleteResponseDTO.builder()
                .success(TRUE)
                .build();
    }

    @Override
    public PostUpdateResponseDTO update(PostUpdateRequestDTO dto, CustomUserDetails userDetails) {
        Post post = findPostById(dto.postId());

        verifyPostOwnership(post, userDetails, PostErrorCode.CANNOT_UPDATE_OTHERS_POST);

        post.updateTitle(dto.updateTitle());
        post.updateContent(dto.updateContent());

        postCommandRepository.save(post);

        return PostUpdateResponseDTO.builder()
                .success(TRUE)
                .build();
    }

    private Post findPostById(Long id) {
        return postCommandRepository.findById(id)
                .orElseThrow(PostErrorCode.NOT_FOUNT_POST::defaultException);
    }

    private Member findMemberByToken(CustomUserDetails userDetails) {
        return memberRepository.findById(userDetails.getId())
                .orElseThrow(AuthenticationErrorCode.MISMATCHED::defaultException);
    }

    private void verifyPostOwnership(Post post, CustomUserDetails userDetails, PostErrorCode errorCode) {
        if (!Objects.equals(post.getMember().getId(), userDetails.getId())) {
            throw new PostException(errorCode);
        }
    }

}
