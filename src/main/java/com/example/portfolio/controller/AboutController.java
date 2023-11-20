package com.example.portfolio.controller;

import com.example.portfolio.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/about")
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;
    @GetMapping("/")
    public ResponseEntity<?> getAllAbout(){
        return ResponseEntity.ok().body(aboutService.getAll());
    }
}
