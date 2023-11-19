package com.example.portfolio.controller;

import com.example.portfolio.service.IntroTopicService;
import com.example.portfolio.service.dto.IntroTopicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class IntroTopicController {
    private final IntroTopicService introTopicService;
    @GetMapping("user/introTopic/")
    public ResponseEntity<?> getAllIntroTopic(){
        return ResponseEntity.ok().body(introTopicService.getAll());
    }
    @GetMapping("user/introTopic/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(introTopicService.getByName(name));
    }
    @GetMapping("user/introTopic/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(introTopicService.getById(id));
    }
    @DeleteMapping("admin/introTopic/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(introTopicService.deleteByName(name));
    }
    @DeleteMapping("admin/introTopic/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(introTopicService.deleteById(id));
    }
    @PostMapping("admin/introTopic")
    public ResponseEntity<?> create(@RequestBody IntroTopicDTO request){
        return ResponseEntity.ok().body(introTopicService.create(request));
    }
    @PutMapping("admin/introTopic/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id",required = true) Integer id, @RequestBody IntroTopicDTO request){
        return ResponseEntity.ok().body(introTopicService.update(id, request));
    }
}
