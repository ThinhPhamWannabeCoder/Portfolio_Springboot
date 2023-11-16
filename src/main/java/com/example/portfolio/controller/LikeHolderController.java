package com.example.portfolio.controller;

import com.example.portfolio.service.LikeHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/likeHolder")
@RequiredArgsConstructor
public class LikeHolderController {
    private final LikeHolderService likeHolderService;
    @GetMapping("/")
    public ResponseEntity<?> getAllLikeHolder(){
        return ResponseEntity.ok().body(likeHolderService.getAll());
    }
}
