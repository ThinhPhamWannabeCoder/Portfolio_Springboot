package com.example.portfolio.controller;

import com.example.portfolio.form.response.FormProjectResponse;
import com.example.portfolio.service.ProjectService;
import com.example.portfolio.service.ProjectSiteService;
import com.example.portfolio.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectSiteService projectSiteService;
    @GetMapping("user/project/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectSiteService.getAllProjects());
    }
    @GetMapping("user/project/topic/{topicId}")
    public ResponseEntity<?> getllAllByTopicId(@PathVariable(name = "topicId", required = true) Integer topicId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectService.getAllByTopicId(topicId));
    }
    @GetMapping("user/project/domain/{name}")
    public ResponseEntity<?> getAllByDomainName(@PathVariable(name ="name", required = true) String domainName){
        try{
            List<FormProjectResponse> response = projectSiteService.getAllProjectsByDomainName(domainName);
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cut");
        }

    }
    @GetMapping("user/project/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(projectService.getById(id));
    }
    @GetMapping("user/project/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(projectService.getByName(name));
    }
    @DeleteMapping("admin/project/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(projectService.deleteById(id));
    }
    @DeleteMapping("admin/project/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(projectService.deleteByName(name));
    }
    @PostMapping("admin/project/")
    public ResponseEntity<?> create(@RequestBody ProjectDTO request){
        return ResponseEntity.ok().body(projectService.create(request));
    }
    @PutMapping("admin/project/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id, @RequestBody ProjectDTO request){
        return ResponseEntity.ok().body(projectService.update(id, request));
    }
}
