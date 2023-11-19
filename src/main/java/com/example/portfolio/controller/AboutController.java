package com.example.portfolio.controller;

import com.example.portfolio.service.AboutService;
import com.example.portfolio.service.dto.AboutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;
    @GetMapping("user/about/")
    public ResponseEntity<?> getAllAbout(){
        return ResponseEntity.ok().body(aboutService.getAll());
    }
    @GetMapping("user/about/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id",required = true) Integer id){
        return ResponseEntity.ok().body(aboutService.getById(id));
    }
    @DeleteMapping("admin/about/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id",required = true) Integer id){
        return ResponseEntity.ok().body(aboutService.deleteById(id));
    }
    @PostMapping("admin/about/")
    public ResponseEntity<?> create(@RequestBody AboutDTO request){
        return ResponseEntity.ok().body(aboutService.create(request));
    }
    @PutMapping("admin/about/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id",required = true) Integer id, @RequestBody AboutDTO request){
        return ResponseEntity.ok().body(aboutService.update(id,request));
    }
}
