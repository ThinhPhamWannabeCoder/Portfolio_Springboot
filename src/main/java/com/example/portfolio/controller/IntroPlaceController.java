package com.example.portfolio.controller;

import com.example.portfolio.service.IntroPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/introPlace")
@RequiredArgsConstructor
public class IntroPlaceController {
    private final IntroPlaceService introPlaceService;
    @GetMapping("/")
    public ResponseEntity<?> getAllIntroPlace(){
        return ResponseEntity.ok().body(introPlaceService.getAll());
    }
    @GetMapping("/{placeName}/")
    public ResponseEntity<?> getAllByPlaceName(@PathVariable(name = "placeName", required = true) String placeName){
        return ResponseEntity.ok().body(introPlaceService.getByName(placeName));
    }
}
