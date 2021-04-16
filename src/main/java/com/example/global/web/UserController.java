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



    @PutMapping("/updateProfile/{id}")
    public ResponseEntity<User> updateProfile(@RequestBody User user,@PathVariable("id") Long id)
    {
       return new ResponseEntity<>(userService.updateProfile(user,id), OK) ;
    }

}
