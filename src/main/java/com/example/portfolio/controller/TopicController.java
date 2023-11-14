package com.example.portfolio.controller;

import com.example.portfolio.service.SkillService;
import com.example.portfolio.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(topicService.getAll());
    }
    @GetMapping("/domain/{domainId}")
    public ResponseEntity<?> getAllBySkillTypeId(@PathVariable(name="domainId", required = true) Integer domainId){
        return ResponseEntity.ok().body(topicService.getByDomainId(domainId));
    }
}
