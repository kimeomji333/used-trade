package com.sparta.usedtrade.service;

import com.sparta.usedtrade.dto.PostRequestDto;
import com.sparta.usedtrade.dto.PostResponseDto;
import com.sparta.usedtrade.entity.Post;
import com.sparta.usedtrade.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 판매 게시글 작성
    public PostResponseDto createPost(PostRequestDto requestDto) {

        Post post = new Post(requestDto);
        postRepository.save(post);
        PostResponseDto responseDto = new PostResponseDto(post);
        return responseDto;
    }

    // 판매 게시글 상세 조회
    public PostResponseDto getPost(Long id) {
        Post post = findPost(id);
        return new PostResponseDto(post);
    }

    // 판매 게시글 전체 리스트 조회
    public List<PostResponseDto> getPosts() {
        return postRepository.findAll().stream().map(PostResponseDto::new).toList();
    }

    // 판매 게시글 수정
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = findPost(id);
        post.update(requestDto);
        return new PostResponseDto(post);
    }

    // 게시글 삭제
    public String deletePost(Long id) {
        Post post = findPost(id);
        postRepository.delete(post);
        return "msg : 삭제 완료";
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 포스팅은 존재하지 않습니다.")
        );
    }
}
