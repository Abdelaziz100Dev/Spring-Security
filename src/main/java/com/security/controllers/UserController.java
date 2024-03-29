package com.security.controllers;

import com.security.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("")
    public ResponseEntity<MessageDto> printhHello(){
        return ResponseEntity.ok(new MessageDto("hello user"));
    }
}
