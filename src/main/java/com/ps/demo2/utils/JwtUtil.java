package com.ps.demo2.utils;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

import java.util.Date;

// @Component
public class JwtUtil {

    // private String secret = "your_secret_key";

    // public String generateToken(String username) {
    // return Jwts.builder()
    // .setSubject(username)
    // .setIssuedAt(new Date(System.currentTimeMillis()))
    // .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //
    // 10 hours
    // .signWith(SignatureAlgorithm.HS256, secret)
    // .compact();
    // }

    // public Boolean validateToken(String token, String username) {
    // final String extractedUsername = extractUsername(token);
    // return (extractedUsername.equals(username) && !isTokenExpired(token));
    // }

    // public String extractUsername(String token) {
    // return extractAllClaims(token).getSubject();
    // }

    // private Claims extractAllClaims(String token) {
    // return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    // }

    // private Boolean isTokenExpired(String token) {
    // return extractAllClaims(token).getExpiration().before(new Date());
    // }
}
