package com.example.portfolio.controller;

import com.example.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectService.getAll());
    }
    @GetMapping("/topic/{topicId}")
    public ResponseEntity<?> GetllAllByTopicId(@PathVariable(name = "topicId", required = true) Integer topicId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectService.getByTopicId(topicId));
    }

}
