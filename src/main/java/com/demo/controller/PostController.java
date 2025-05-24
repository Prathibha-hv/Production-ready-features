package com.demo.controller;

import com.demo.dto.PostDto;
import com.demo.entity.PostEntity;
import com.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequiredArgsConstructor

@RequestMapping(path="/api")
public class PostController {

   private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostDto> getAllPosts()
    {
        return service.getAllPosts();
    }

    @PostMapping
    public PostDto createPosts(@RequestBody PostDto dto)
    {
       return service.createNewPost(dto);
    }

    @GetMapping(path = "/{id}")
    public PostDto getPostbyId(@PathVariable Long id)
    {
        return service.getPostById(id);
    }

    @PutMapping("/{id}")
    public  PostDto updatePost(@RequestBody PostDto updatedPost, @PathVariable long id)
    {
        PostDto updatePost=service.updatePost(updatedPost,id);
        return null;
    }
}
