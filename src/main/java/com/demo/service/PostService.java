package com.demo.service;

import com.demo.dto.PostDto;
import com.demo.entity.PostEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface PostService {

 List<PostDto> getAllPosts();
 PostDto createNewPost(PostDto dto);

 PostDto getPostById(Long id);

    PostDto updatePost(PostDto updatedPost, long id);
}
