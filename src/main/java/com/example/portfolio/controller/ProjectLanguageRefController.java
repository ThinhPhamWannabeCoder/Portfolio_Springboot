package com.example.portfolio.controller;

import com.example.portfolio.form.request.FormProjectLanguage;
import com.example.portfolio.service.ProjectLanguageRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class ProjectLanguageRefController {
    private final ProjectLanguageRefService projectLanguageRefService;

    @GetMapping("user/projectLanguage/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(projectLanguageRefService.getAll());
    }
    @GetMapping("user/projectLanguage/project/{projectId}")
    public ResponseEntity<?> getAllByProjectId(@PathVariable(name = "projectId", required = true) Integer projectId){
        return ResponseEntity.ok().body(projectLanguageRefService.getAllByProjectId(projectId));
    }
    @GetMapping("user/projectLanguage/language/{languageId}")
    public ResponseEntity<?> getAllSkillsByLanguageId(@PathVariable(name = "languageId", required = true) Integer languageId){
        return ResponseEntity.ok().body(projectLanguageRefService.getAllByLanguageId(languageId));
    }
    @GetMapping("user/projectLanguage/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(projectLanguageRefService.getById(id));
    }

    @DeleteMapping("admin/projectLanguage/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(projectLanguageRefService.deleteById(id));
    }

    @PostMapping("admin/projectLanguage/")
    public ResponseEntity<?> create(@RequestBody FormProjectLanguage request){
        return ResponseEntity.ok().body(projectLanguageRefService.create(request));
    }
    @PutMapping("admin/projectLanguage/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id, @RequestBody FormProjectLanguage request){
        return ResponseEntity.ok().body(projectLanguageRefService.update(id, request));
    }
}
