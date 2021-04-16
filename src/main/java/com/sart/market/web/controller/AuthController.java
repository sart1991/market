package com.sart.market.web.controller;

import com.sart.market.domain.dto.AuthenticationRequest;
import com.sart.market.domain.dto.AuthenticationResponse;
import com.sart.market.domain.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping()
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest req) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
            UserDetails details = (UserDetails) auth.getPrincipal();
            String jwt = userAuthService.generateToken(details);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
