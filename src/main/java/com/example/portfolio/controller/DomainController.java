package com.example.portfolio.controller;

import com.example.portfolio.service.DomainService;
import com.example.portfolio.service.DomainSkillRefService;
import com.example.portfolio.service.dto.DomainDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class DomainController {
    private final DomainService domainService;
    @GetMapping("user/domain/")
    public ResponseEntity<?> getAllDomain(){
        return ResponseEntity.ok().body(domainService.getAll());
    }
    @GetMapping("user/domain/name/{name}")
    public ResponseEntity<?> getByDomainName(@PathVariable(name = "name",required = true) String name){
        return ResponseEntity.ok().body(domainService.getByName(name));
    }
    @GetMapping("user/domain/id/{id}")
    public ResponseEntity<?> getByDomainId(@PathVariable(name = "id",required = true) Integer id){
        return ResponseEntity.ok().body(domainService.getById(id));
    }
    @DeleteMapping("admin/domain/name/{name}")
    public ResponseEntity<?> deleteByDomainName(@PathVariable(name = "name",required = true) String name){
        return ResponseEntity.ok().body(domainService.deleteByName(name));
    }
    @DeleteMapping("admin/domain/id/{id}")
    public ResponseEntity<?> deleteByDomainId(@PathVariable(name = "id",required = true) Integer id){
        return ResponseEntity.ok().body(domainService.deleteById(id));
    }
    @PostMapping("admin/domain/")
    public ResponseEntity<?> create(@RequestBody DomainDTO request){
        return ResponseEntity.ok().body(domainService.create(request));
    }
    @PutMapping("admin/domain/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id",required = true) Integer id, @RequestBody DomainDTO request){
        return ResponseEntity.ok().body(domainService.update(id,request));
    }
}
