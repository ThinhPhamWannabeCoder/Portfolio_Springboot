package com.example.portfolio.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String jwtToken;
    private String type ;
    // Constructor
//    public AuthResponse(String jwtToken) {
//        this.jwtToken = jwtToken;
//        this.type = "jwt";
//    }
}
