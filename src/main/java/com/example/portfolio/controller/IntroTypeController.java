package com.example.portfolio.controller;

import com.example.portfolio.service.IntroTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/introType")
@RequiredArgsConstructor
public class IntroTypeController {
    private final IntroTypeService introTypeService;
    @GetMapping("/")
    public ResponseEntity<?> getAllIntroType(){
        return ResponseEntity.ok().body(introTypeService.getAll());
    }
}
