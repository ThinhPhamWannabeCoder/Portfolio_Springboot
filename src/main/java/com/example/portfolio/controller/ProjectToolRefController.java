package com.example.portfolio.controller;

import com.example.portfolio.service.ProjectToolRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/projectTool")
@RequiredArgsConstructor
public class ProjectToolRefController {
    private final ProjectToolRefService projectToolRefService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(projectToolRefService.getAll());
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getAllByProjectId(@PathVariable(name = "projectId", required = true) Integer projectId){
        return ResponseEntity.ok().body(projectToolRefService.getByProjectId(projectId));
    }
    @GetMapping("/tool/{toolId}")
    public ResponseEntity<?> getAllSkillsByLanguageId(@PathVariable(name = "toolId", required = true) Integer toolId){
        return ResponseEntity.ok().body(projectToolRefService.getByToolId(toolId));
    }
}
