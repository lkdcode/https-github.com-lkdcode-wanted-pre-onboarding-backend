package com.example.wantedbackend.module.Post.domain.repository;

import com.example.wantedbackend.module.Post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
