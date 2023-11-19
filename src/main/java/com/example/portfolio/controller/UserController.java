package com.example.portfolio.controller;

import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.UserService;
import com.example.portfolio.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> findAll(){
        return  ResponseEntity.ok().body(userService.getAll());
    }
    //    @GetMapping("/test")
//    public ResponseEntity<?> test(@RequestBody String email){
//        try{
//            UserDetails optionalUserEntity = userService.loadUserByUsername(email);
//
//            return ResponseEntity.ok().body(optionalUserEntity);
//        }
//        catch (Exception e){
//            return ResponseEntity.ok().body(e.getMessage());
//        }
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(userService.getById(id));
    }
    @GetMapping("/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable(name = "email", required = true) String email){
        return ResponseEntity.ok().body(userService.getByEmail(email));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable(name = "id", required = true) Integer id){
        return ResponseEntity.ok().body(userService.deleteById(id));
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteByEmail(@PathVariable(name = "email", required = true) String email){
        return ResponseEntity.ok().body(userService.deleteByEmail(email));
    }
    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {

        try{
            if(userService.exists(userDTO.getEmail())){
                return ResponseEntity.badRequest().body("User is taken");
            }
            if(userService.create(userDTO)){
                return ResponseEntity.ok("Da update thanh cong");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Khong update thanh cong");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Integer id,@RequestBody UserDTO userDTO) {
//
//        return ResponseEntity.ok().body(userService.update(id, userDTO));
//
//    }

}
