package com.example.portfolio.auth;

import com.example.portfolio.form.FormUserLogin;
import com.example.portfolio.service.UserService;
import com.example.portfolio.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(UserDTO userDTO){
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        if(userService.create(userDTO)){
            UserDetails userDetails = userService.loadUserByUsername(userDTO.getEmail());
            String token =jwtService.generateToken(userDetails);
            return AuthResponse.builder().jwtToken(token).build();

        }
        return null;
    }
    public AuthResponse login(FormUserLogin formUserLogin){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        formUserLogin.getEmail(),
                        formUserLogin.getPassword()
                )
        );
        UserDetails userDetails = userService.loadUserByUsername(formUserLogin.getEmail());
        String token =jwtService.generateToken(userDetails);
        return AuthResponse.builder().jwtToken(token).build();
    }
}
