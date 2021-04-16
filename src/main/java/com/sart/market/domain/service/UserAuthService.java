package com.sart.market.domain.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Service
public class UserAuthService implements UserDetailsService {

    private static final String KEY = "1234!";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HashMap<String, String> userPassword = new HashMap<>();
        userPassword.put("admin", "{noop}1234");
        if (!userPassword.containsKey(username)) return null;
        return new User(username, userPassword.get(username), new ArrayList<>());
    }

    public String generateToken(UserDetails details) {
        return Jwts.builder()
                .setSubject(details.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60)))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public UserDetails validateJWT(String jwt) {
        Claims claims = extractJWTBody(jwt);
        boolean isExpired = isJWTExpired(claims);
        if (isExpired) return null;
        String jwtUsername = extractJWTUsername(claims);
        UserDetails details = loadUserByUsername(jwtUsername);
        if (details == null) return null;
        if(!jwtUsername.equals(details.getUsername())) return null;
        return details;
    }

    private String extractJWTUsername(Claims claims) {
        return claims.getSubject();
    }

    private boolean isJWTExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

    private Claims extractJWTBody(String jwt) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt).getBody();
    }

}
