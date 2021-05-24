package com.example.global.web;

import com.example.global.dao.UserRepository;

import com.example.global.dto.CustomResponse;
import com.example.global.dto.MyRequest;
import com.example.global.entities.CustomUserDetail;
import com.example.global.entities.Ligne;
import com.example.global.entities.Test;
import com.example.global.entities.User;
import com.example.global.exceptions.UserNotFoundException;
import com.example.global.metier.TestService;
import com.example.global.util.TrackerUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private final UserRepository userRepository ;
    private final TrackerUtil trackerUtil ;
    private final TestService testService ;
    
    @GetMapping
    public  ResponseEntity<?> get(){

        Ligne ligne = new Ligne();
        ligne.setLabel("hello");
        Map<String,String> errors = new HashMap();
        errors.put("name","invalid name");
        return new ResponseEntity<Map>(errors,OK);
    }




}
