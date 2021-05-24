package com.example.global.web;

import com.example.global.entities.User;
import com.example.global.metier.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;



    @PutMapping("/updateProfile")
    public ResponseEntity<User> updateProfile(@RequestBody User user)
    {
       return new ResponseEntity<>(userService.updateProfile(user), OK) ;
    }

    @GetMapping("/getCurrentUser")
    public ResponseEntity<User> getCurrentUser()
    {
        return new ResponseEntity<User>(userService.getCurrentUser(), OK) ;
    }



}
