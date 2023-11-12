package com.example.portfolio.auth;

import com.example.portfolio.form.FormUserLogin;
import com.example.portfolio.service.UserService;
import com.example.portfolio.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
        if(userService.exists(userDTO.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User name's already taken");
        }
        AuthResponse response = authService.register(userDTO);
        if (response==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot return jwt");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody FormUserLogin request){
        return ResponseEntity.ok().body(authService.login(request));
    }
}
