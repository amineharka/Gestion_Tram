package com.example.global.web;

import com.example.global.dto.LoginRequest;
import com.example.global.dto.RegisterRequest;
import com.example.global.entities.User;
import com.example.global.metier.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest)
    {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful", OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> signUp(@RequestBody LoginRequest loginRequest)
    {
        return new ResponseEntity<User>(authService.login(loginRequest), OK);
    }


}
