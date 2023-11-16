package com.example.portfolio.controller;

import com.example.portfolio.service.DomainService;
import com.example.portfolio.service.DomainSkillRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/domain")
@RequiredArgsConstructor
public class DomainController {
    private final DomainService domainService;
    @GetMapping("/")
    public ResponseEntity<?> getAllDomain(){
        return ResponseEntity.ok().body(domainService.getAll());
    }
}
