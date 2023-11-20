package com.example.portfolio.controller;

import com.example.portfolio.form.request.FormIntroFilter;
import com.example.portfolio.service.IntroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/intro")
@RequiredArgsConstructor
public class IntroController {
    private final IntroService introService;
    @GetMapping("/")
    public ResponseEntity<?> getAllIntro(){
        return ResponseEntity.ok().body(introService.getAll());
    }
    @GetMapping("/topic/{topicId}")
    public ResponseEntity<?> getAllByIntroTopicId(@PathVariable(name = "topicId", required = true) Integer topicId ){
        return ResponseEntity.ok().body(introService.getAllByIntroTopicId(topicId));
    }
    @GetMapping("/place/{placeId}")
    public ResponseEntity<?> getAllByIntroPlaceId(@PathVariable(name = "placeId", required = true) Integer placeId){
        return ResponseEntity.ok().body(introService.getAllByIntroPlaceId(placeId));
    }
    @GetMapping("/type/{typeId}")
    public ResponseEntity<?> getAllByIntroTypeId(@PathVariable(name = "typeId", required = true) Integer typeId){
        return ResponseEntity.ok().body(introService.getAllByIntroTypeId(typeId));
    }
    @PostMapping("/filter/")
    public ResponseEntity<?> getAllWithAllFilter(@RequestBody FormIntroFilter request){
        return ResponseEntity.ok().body(introService.getAllByTopicIdPlaceIdTypeId(request));
    }
}
