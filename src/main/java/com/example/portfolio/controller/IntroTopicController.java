package com.example.portfolio.controller;

import com.example.portfolio.service.IntroTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/introTopic")
@RequiredArgsConstructor
public class IntroTopicController {
    private final IntroTopicService introTopicService;
    @GetMapping("/")
    public ResponseEntity<?> getAllIntroTopic(){
        return ResponseEntity.ok().body(introTopicService.getAll());
    }
}
