package com.example.portfolio.controller;

import com.example.portfolio.form.request.FormProjectTool;
import com.example.portfolio.service.ProjectToolRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class ProjectToolRefController {
    private final ProjectToolRefService projectToolRefService;

    @GetMapping("user/projectTool/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(projectToolRefService.getAll());
    }
    @GetMapping("user/projectTool/project/{projectId}")
    public ResponseEntity<?> getAllByProjectId(@PathVariable(name = "projectId", required = true) Integer projectId){
        return ResponseEntity.ok().body(projectToolRefService.getAllByProjectId(projectId));
    }
    @GetMapping("user/projectTool/tool/{toolId}")
    public ResponseEntity<?> getAllSkillsByLanguageId(@PathVariable(name = "toolId", required = true) Integer toolId){
        return ResponseEntity.ok().body(projectToolRefService.getByToolId(toolId));
    }
    @GetMapping("user/projectTool/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(projectToolRefService.getById(id));
    }

    @DeleteMapping("admin/projectTool/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(projectToolRefService.deleteById(id));
    }

    @PostMapping("admin/projectTool/")
    public ResponseEntity<?> create(@RequestBody FormProjectTool request){
        return ResponseEntity.ok().body(projectToolRefService.create(request));
    }
    @PutMapping("admin/projectTool/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id, @RequestBody FormProjectTool request){
        return ResponseEntity.ok().body(projectToolRefService.update(id, request));
    }
}
