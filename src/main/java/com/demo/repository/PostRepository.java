package com.demo.repository;

import com.demo.dto.PostDto;
import com.demo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {



}
