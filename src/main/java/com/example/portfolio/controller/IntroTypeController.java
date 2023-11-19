package com.example.portfolio.controller;

import com.example.portfolio.service.IntroTypeService;
import com.example.portfolio.service.dto.IntroTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class IntroTypeController {
    private final IntroTypeService introTypeService;
    @GetMapping("user/introType/")
    public ResponseEntity<?> getAllIntroType(){
        return ResponseEntity.ok().body(introTypeService.getAll());
    }
    @GetMapping("user/introType/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(introTypeService.getByName(name));
    }
    @GetMapping("user/introType/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(introTypeService.getById(id));
    }
    @DeleteMapping("admin/introType/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(introTypeService.deleteByName(name));
    }
    @DeleteMapping("admin/introType/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(introTypeService.deleteById(id));
    }
    @PostMapping("admin/introType")
    public ResponseEntity<?> create(@RequestBody IntroTypeDTO request){
        return ResponseEntity.ok().body(introTypeService.create(request));
    }
    @PutMapping("admin/introType/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id",required = true) Integer id, @RequestBody IntroTypeDTO request){
        return ResponseEntity.ok().body(introTypeService.update(id, request));
    }
}
