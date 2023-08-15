package com.example.wantedbackend.post.repository;

import com.example.wantedbackend.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostQueryRepository extends JpaRepository<Post, Long> {
    Page<Post> findAll(final Pageable pageable);

}
