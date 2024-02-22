package com.example.portfolio.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String SECRET_KEY = "moMSg5GfX0woy/jZBW3UP0dtRh+V9Gcb1jV5RoFsOD8h1iQCyGQdPKbOpYF7jx/P";

    public boolean isTokenValid(String jwt, UserDetails userDetails){
        String username = extractUseremail(jwt);
        return (username.equals(userDetails.getUsername())) &&  (!isTokenExpired(jwt));
    }
    public boolean isTokenExpired(String jwt){
        return extractExpiration(jwt).before(new Date());
    }
    public String extractUseremail(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }
    public Date extractExpiration(String jwt){
        return extractClaim(jwt, Claims::getExpiration);
    }
    //    Dung Generic la de lam co the extract duoc nhieu type hon
    public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String jwt){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
    public String generateToken(UserDetails user){
        return generateToken(new HashMap<>(), user);
    }
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails  user
    ){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*24) )
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    //    Phai de la kieu Key thi moi add duoc vao chu khong duoc de thang SECRETKEY
    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
