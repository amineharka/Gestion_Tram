package com.example.global.web;

import com.example.global.dto.AlimenterRequest;
import com.example.global.entities.Alimentation;
import com.example.global.metier.VoyageurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/voyageur")
@AllArgsConstructor
public class VoyageurController {

    private final VoyageurService voyageurService ;
    
    @GetMapping("/consulterAlimentations/{id}")
    public ResponseEntity<List<Alimentation>> consulterAlimentations(@PathVariable("id") Long id)
    {
        return new ResponseEntity<List<Alimentation>>(voyageurService.getAllAlimentationByVoyageur(id), OK);
    }
    
    @PostMapping("/alimenterSolde")
    public ResponseEntity<Alimentation> alimenterSolde(@RequestBody AlimenterRequest alimenterRequest)
    {
        return new ResponseEntity<>(voyageurService.alimenter(alimenterRequest), OK);
    }


}
