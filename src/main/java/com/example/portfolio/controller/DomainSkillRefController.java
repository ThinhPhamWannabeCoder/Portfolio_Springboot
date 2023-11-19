package com.example.portfolio.controller;

import com.example.portfolio.service.DomainSkillRefService;
import com.example.portfolio.service.dto.DomainSkillRefDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class DomainSkillRefController {
    private final DomainSkillRefService domainSkillRefService;
    @GetMapping("user/domainSkill/")
    public ResponseEntity<?> getAllSkillsDomain(){
        return ResponseEntity.ok().body(domainSkillRefService.getAll());
    }
    @GetMapping("user/domainSkill/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(domainSkillRefService.getById(id));
    }
    @GetMapping("user/domainSkill/domain/{domainId}")
    public ResponseEntity<?> getAllSkillsByDomainId(@PathVariable(name = "domainId", required = true) Integer domainId){
        return ResponseEntity.ok().body(domainSkillRefService.geByDomainId(domainId));
    }
    @GetMapping("user/domainSkill/skill/{skillId}")
    public ResponseEntity<?> getAllSkillsBySkillId(@PathVariable(name = "skillId", required = true) Integer skillId){
        return ResponseEntity.ok().body(domainSkillRefService.getBySkillId(skillId));
    }
    @DeleteMapping("admin/domainSkill/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(domainSkillRefService.deleteById(id));
    }
    @PostMapping("admin/domainSkill")
    public ResponseEntity<?> create(@RequestBody DomainSkillRefDTO request){
        return ResponseEntity.ok().body(domainSkillRefService.create(request));
    }
    @PutMapping("admin/domainSkill/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id, @RequestBody DomainSkillRefDTO request){
        return ResponseEntity.ok().body(domainSkillRefService.update(id, request));
    }
}
