package com.demo.controller;

import com.demo.dto.PostDto;
import com.demo.entity.PostEntity;
import com.demo.service.PostService;
import com.demo.service.impl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequiredArgsConstructor


@RequestMapping(path="/api")
public class PostController {
    Logger log= LoggerFactory.getLogger(PostServiceImpl.class);

   private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostDto> getAllPosts()
    {
        log.info("Executed get all posts");
        log.info("Simple info ablout post controller");
        log.warn("its warning to follow industry standards ");
        log.debug("debugging...");
        log.trace("In detail info about the flow of control and execution");
        return service.getAllPosts();
    }

    @PostMapping(path = "/newPost")
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
