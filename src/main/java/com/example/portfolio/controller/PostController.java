package com.example.portfolio.controller;

import com.example.portfolio.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/")
    public ResponseEntity<?> getAllPost(){
        return ResponseEntity.ok().body(postService.getAll());
    }
}
