package com.example.portfolio.controller;

import com.example.portfolio.service.IntroPlaceService;
import com.example.portfolio.service.dto.IntroPlaceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class IntroPlaceController {
    private final IntroPlaceService introPlaceService;
    @GetMapping("user/introPlace/")
    public ResponseEntity<?> getAllIntroPlace(){
        return ResponseEntity.ok().body(introPlaceService.getAll());
    }
    @GetMapping("user/introPlace/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(introPlaceService.getByName(name));
    }
    @GetMapping("user/introPlace/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(introPlaceService.getById(id));
    }
    @DeleteMapping("admin/introPlace/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(name = "name", required = true) String name){
        return ResponseEntity.ok().body(introPlaceService.deleteByName(name));
    }
    @DeleteMapping("admin/introPlace/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(introPlaceService.deleteById(id));
    }
    @PostMapping("admin/introPlace")
    public ResponseEntity<?> create(@RequestBody IntroPlaceDTO request){
        return ResponseEntity.ok().body(introPlaceService.create(request));
    }
    @PutMapping("admin/introPlace/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id",required = true) Integer id, @RequestBody IntroPlaceDTO request){
        return ResponseEntity.ok().body(introPlaceService.update(id, request));
    }



}
