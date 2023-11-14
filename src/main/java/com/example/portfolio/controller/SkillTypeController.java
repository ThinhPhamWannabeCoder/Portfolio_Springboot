package com.example.portfolio.controller;

import com.example.portfolio.service.SkillService;
import com.example.portfolio.service.SkillTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skilltype")
@RequiredArgsConstructor
public class SkillTypeController {
    private final SkillTypeService skillTypeService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(skillTypeService.getAll());
    }
}
