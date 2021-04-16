package com.sart.market.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTool {

    private static final String KEY = "1234!";

    public String generateToken(UserDetails details) {
        return Jwts.builder()
                .setSubject(details.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60)))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

}
