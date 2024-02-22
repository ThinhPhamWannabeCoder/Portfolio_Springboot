package com.example.portfolio.controller;

import com.example.portfolio.service.SkillService;
import com.example.portfolio.service.SkillsSiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;
    private final SkillsSiteService skillsSiteService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(skillsSiteService.getAllSkills());
    }
    @GetMapping("/skilltype/{skillTypeId}")
    public ResponseEntity<?> getAllBySkillTypeId(@PathVariable(name="skillTypeId", required = true) Integer skillTypeId){
        return ResponseEntity.ok().body(skillService.getBySkillTypeId(skillTypeId));
    }
}
