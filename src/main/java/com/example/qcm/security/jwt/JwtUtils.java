package com.example.qcm.security.jwt;

import com.example.qcm.repository.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.utils.secret}")
    private String jwtSecret;
    @Value("${jwt.utils.expiration.duration}")
    private long expirationMs;

    public String generateJwtToken(Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        return Jwts
                .builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + this.expirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
