package com.example.global.web;

import com.example.global.dao.UserRepository;
import com.example.global.entities.User;
import com.example.global.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private final UserRepository userRepository ;
    
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) throws UserNotFoundException {
        return userRepository.findById(id).get();
    }
}
