package com.example.portfolio.controller;

import com.example.portfolio.service.SkillService;
import com.example.portfolio.service.SkillTypeService;
import com.example.portfolio.service.dto.SkillTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class SkillTypeController {
    private final SkillTypeService skillTypeService;

    @GetMapping("user/skillType/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(skillTypeService.getAll());
    }
    @GetMapping("user/skillType/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(skillTypeService.getById(id));
    }
    @GetMapping("user/skillType/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(skillTypeService.getByName(name));
    }
    @DeleteMapping("admin/skillType/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(skillTypeService.deleteById(id));
    }
    @DeleteMapping("admin/skillType/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(skillTypeService.deleteByName(name));
    }
    @PostMapping("admin/skillType/")
    public ResponseEntity<?> create(@RequestBody SkillTypeDTO request){
        return ResponseEntity.ok().body(skillTypeService.create(request));
    }
    @PutMapping("admin/skillType/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id, @RequestBody SkillTypeDTO request){
        return ResponseEntity.ok().body(skillTypeService.update(id, request));
    }

}
