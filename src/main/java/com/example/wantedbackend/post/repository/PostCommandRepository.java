package com.example.wantedbackend.post.repository;

import com.example.wantedbackend.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommandRepository extends JpaRepository<Post, Long> {

}
