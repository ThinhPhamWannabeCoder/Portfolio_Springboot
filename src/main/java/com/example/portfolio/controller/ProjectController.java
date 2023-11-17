package com.example.portfolio.controller;

import com.example.portfolio.form.response.FormProjectResponse;
import com.example.portfolio.service.ProjectService;
import com.example.portfolio.service.ProjectSiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectSiteService projectSiteService;
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectSiteService.getAllProjects());
    }
    @GetMapping("/topic/{topicId}")
    public ResponseEntity<?> getllAllByTopicId(@PathVariable(name = "topicId", required = true) Integer topicId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectService.getAllByTopicId(topicId));
    }
    @GetMapping("/domain/{name}")
    public ResponseEntity<?> getAllByDomainName(@PathVariable(name ="name", required = true) String domainName){
        try{
            List<FormProjectResponse> response = projectSiteService.getAllProjectsByDomainName(domainName);
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cut");
        }

    }

}
