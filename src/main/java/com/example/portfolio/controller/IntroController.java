package com.example.portfolio.controller;

import com.example.portfolio.form.request.FormIntro;
import com.example.portfolio.form.request.FormIntroFilter;
import com.example.portfolio.service.IntroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class IntroController {
    private final IntroService introService;
    @GetMapping("user/intro/")
    public ResponseEntity<?> getAllIntro(){
        return ResponseEntity.ok().body(introService.getAll());
    }
    @GetMapping("user/intro/topic/{topicId}")
    public ResponseEntity<?> getAllByIntroTopicId(@PathVariable(name = "topicId", required = true) Integer topicId ){
        return ResponseEntity.ok().body(introService.getAllByIntroTopicId(topicId));
    }
    @GetMapping("user/intro/place/{placeId}")
    public ResponseEntity<?> getAllByIntroPlaceId(@PathVariable(name = "placeId", required = true) Integer placeId){
        return ResponseEntity.ok().body(introService.getAllByIntroPlaceId(placeId));
    }
    @GetMapping("user/intro/type/{typeId}")
    public ResponseEntity<?> getAllByIntroTypeId(@PathVariable(name = "typeId", required = true) Integer typeId){
        return ResponseEntity.ok().body(introService.getAllByIntroTypeId(typeId));
    }
    @PostMapping("user/intro/filter/")
    public ResponseEntity<?> getAllWithAllFilter(@RequestBody FormIntroFilter request){
        return ResponseEntity.ok().body(introService.getAllByTopicIdPlaceIdTypeId(request));
    }
    @DeleteMapping("admin/intro/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id",required = true) Integer id){
        return ResponseEntity.ok().body(introService.deleteById(id));
    }

    @PostMapping("admin/intro/")
    public ResponseEntity<?> create(@RequestBody FormIntro request){
        return ResponseEntity.ok().body(introService.create(request));
    }
    @PutMapping("admin/intro/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id",required = true) Integer id, @RequestBody FormIntro request){
        return ResponseEntity.ok().body(introService.update(id, request));
    }

}
