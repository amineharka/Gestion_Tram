package com.example.global.web;

import com.example.global.dto.MyRequest;
import com.example.global.entities.Alimentation;
import com.example.global.entities.ResponsableGuichet;
import com.example.global.entities.Voyageur;
import com.example.global.metier.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService ;


    @GetMapping("/consulterAlimentations")
    public ResponseEntity<List<Alimentation>> consulterAlimentations()
    {
        return new ResponseEntity<>(adminService.getAllAlimentations(), OK) ;
    }

    @GetMapping("/consulterVoyageurs")
    public ResponseEntity<List<Voyageur>> consulterVoyageurs()
    {
        return new ResponseEntity<>(adminService.getAllVoyageurs(), OK) ;
    }
    
    @PostMapping("/creerRespo")
    public ResponseEntity<ResponsableGuichet> creerRespo(@RequestBody MyRequest myRequest)
    {
      return new ResponseEntity<>(adminService.creerRespo(myRequest), OK);
    }

    @GetMapping("/consulterRespos")
    public ResponseEntity<List<ResponsableGuichet>> consulterRespos()
    {
        return new ResponseEntity<>(adminService.getAllRespos(), OK) ;
    }

    @DeleteMapping("/deleteRespo/{id}")
    public ResponseEntity<String> deleteRespo(@PathVariable("id") Long id)
    {
        adminService.deleteRespo(id);
        return new ResponseEntity<>("Responsable deleted succefully", OK);
    }
}
