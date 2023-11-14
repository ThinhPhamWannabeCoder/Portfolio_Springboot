package com.example.portfolio.controller;

import com.example.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(skillService.getAll());
    }
    @GetMapping("/skilltype/{skillTypeId}")
    public ResponseEntity<?> getAllBySkillTypeId(@PathVariable(name="skillTypeId", required = true) Integer skillTypeId){
        return ResponseEntity.ok().body(skillService.getBySkillTypeId(skillTypeId));
    }
}
