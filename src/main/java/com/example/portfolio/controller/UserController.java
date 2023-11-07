package com.example.portfolio.controller;

import com.example.portfolio.service.UserService;
import com.example.portfolio.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin/user")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {
        if(userService.create(userDTO)){
            return ResponseEntity.ok("Da update thanh cong");
        }
        else{
            return ResponseEntity.badRequest().body("Khong update thanh cong");
        }
    }
    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(){
        return  ResponseEntity.ok().body(userService.getAll());
    }
}
