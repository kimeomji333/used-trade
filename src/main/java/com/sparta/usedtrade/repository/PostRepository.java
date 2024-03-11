package com.sparta.usedtrade.repository;

import com.sparta.usedtrade.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
