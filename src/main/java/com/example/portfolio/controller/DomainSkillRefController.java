package com.example.portfolio.controller;

import com.example.portfolio.service.DomainSkillRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/domainSkill")
@RequiredArgsConstructor
public class DomainSkillRefController {
    private final DomainSkillRefService domainSkillRefService;
    @GetMapping("/")
    public ResponseEntity<?> getAllSkillsDomain(){
        return ResponseEntity.ok().body(domainSkillRefService.getAll());
    }
    @GetMapping("/domain/{domainId}")
    public ResponseEntity<?> getAllSkillsByDomainId(@PathVariable(name = "domainId", required = true) Integer domainId){
        return ResponseEntity.ok().body(domainSkillRefService.geByDomainId(domainId));
    }
    @GetMapping("/skill/{skillId}")
    public ResponseEntity<?> getAllSkillsBySkillId(@PathVariable(name = "skillId", required = true) Integer skillId){
        return ResponseEntity.ok().body(domainSkillRefService.getBySkillId(skillId));
    }
}
