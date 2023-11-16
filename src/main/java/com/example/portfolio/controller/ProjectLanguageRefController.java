package com.example.portfolio.controller;

import com.example.portfolio.service.ProjectLanguageRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/projectLanguage")
@RequiredArgsConstructor
public class ProjectLanguageRefController {
    private final ProjectLanguageRefService projectLanguageRefService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(projectLanguageRefService.getAll());
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getAllByProjectId(@PathVariable(name = "projectId", required = true) Integer projectId){
        return ResponseEntity.ok().body(projectLanguageRefService.getByProjectId(projectId));
    }
    @GetMapping("/language/{languageId}")
    public ResponseEntity<?> getAllSkillsByLanguageId(@PathVariable(name = "languageId", required = true) Integer languageId){
        return ResponseEntity.ok().body(projectLanguageRefService.getByLanguageId(languageId));
    }
}
