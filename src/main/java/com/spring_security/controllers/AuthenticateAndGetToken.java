package com.spring_security.controllers;


import com.spring_security.dto.AuthRequestDTO;
import com.spring_security.dto.JwtResponseDTO;
import com.spring_security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateAndGetToken {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;
    @PostMapping("/api/v1/login")
    public JwtResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            return JwtResponseDTO.builder()
                    .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername()))
                    .build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}