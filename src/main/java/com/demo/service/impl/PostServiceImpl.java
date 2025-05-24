package com.demo.service.impl;

import com.demo.dto.PostDto;
import com.demo.entity.PostEntity;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.PostRepository;
import com.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository repository;
  private final ModelMapper mapper;
    @Override
    public List<PostDto> getAllPosts() {
       return  repository.findAll()
                .stream()
                .map(postEntity->mapper.map(postEntity,PostDto.class))
                        .collect(Collectors.toList());

    }

    @Override
    public PostDto createNewPost(PostDto dto) {
        PostEntity postEntity=mapper.map(dto,PostEntity.class);
        return mapper.map(repository.save(postEntity),PostDto.class);

    }

    public PostDto getPostById(Long id) {
       PostEntity postEntity=repository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Post not found with id: "+id));
     return mapper.map(postEntity,PostDto.class);
    }
}
