package com.example.portfolio.controller;

import com.example.portfolio.form.request.FormSkill;
import com.example.portfolio.service.SkillService;
import com.example.portfolio.service.SkillsSiteService;
import com.example.portfolio.service.dto.SkillDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;
    private final SkillsSiteService skillsSiteService;

    @GetMapping("user/skill/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(skillsSiteService.getAllSkills());
    }
    @GetMapping("user/skill/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(skillService.getById(id));
    }
    @GetMapping("user/skill/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(skillService.getByName(name));
    }
    @GetMapping("user/skill/skilltype/id/{skillId}")
    public ResponseEntity<?> getAllBySkillId(@PathVariable(name="skillId", required = true) Integer skillId){
        return ResponseEntity.ok().body(skillService.getBySkillTypeId(skillId));
    }
    @DeleteMapping("admin/skill/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(skillService.deleteById(id));
    }
    @DeleteMapping("admin/skill/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(skillService.deleteByName(name));
    }
    @PostMapping("admin/skill/")
    public ResponseEntity<?> create(@RequestBody FormSkill request){
        return ResponseEntity.ok().body(skillService.create(request));
    }
    @PutMapping("admin/skill/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id, @RequestBody FormSkill request){
        return ResponseEntity.ok().body(skillService.update(id, request));
    }
}
