package com.example.portfolio.controller;

import com.example.portfolio.service.TopicService;
import com.example.portfolio.service.dto.TopicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping("user/topic/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(topicService.getAll());
    }
    @GetMapping("user/topic/domain/id/{domainId}")
    public ResponseEntity<?> getAllByDomainId(@PathVariable(name="domainId", required = true) Integer domainId){
        return ResponseEntity.ok().body(topicService.getAllByDomainId(domainId));
    }
    @GetMapping("user/topic/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(topicService.getByName(name));
    }
    @GetMapping("user/topic/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(topicService.getById(id));
    }
    @DeleteMapping("admin/topic/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(topicService.deleteByName(name));
    }
    @DeleteMapping("admin/topic/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(topicService.deleteById(id));
    }
    @PostMapping("admin/topic")
    public ResponseEntity<?> create(@RequestBody TopicDTO request){
        return ResponseEntity.ok().body(topicService.create(request));
    }
    @PutMapping("admin/topic/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id",required = true) Integer id, @RequestBody TopicDTO request){
        return ResponseEntity.ok().body(topicService.update(id, request));
    }
}
