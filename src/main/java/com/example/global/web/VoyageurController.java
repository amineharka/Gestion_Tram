package com.example.global.web;

import com.example.global.dto.AlimenterRequest;
import com.example.global.dto.GenerateTicketRequest;
import com.example.global.entities.Alimentation;
import com.example.global.entities.Eticket;
import com.example.global.metier.VoyageurService;
import com.sun.mail.iap.Response;
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
    
    @GetMapping("/consulterAlimentations")
    public ResponseEntity<List<Alimentation>> consulterAlimentations()
    {
        return new ResponseEntity<List<Alimentation>>(voyageurService.getMyAlimentation(), OK);
    }
    
    @PostMapping("/alimenterSolde")
    public ResponseEntity<Alimentation> alimenterSolde(@RequestBody AlimenterRequest alimenterRequest)
    {
        System.out.println("hello "+alimenterRequest.getCardNumber());
        System.out.println("hello "+alimenterRequest.getMontant());
        return new ResponseEntity<>(voyageurService.alimenter(alimenterRequest), OK);
    }

    @PostMapping("/generateTicket")
    public ResponseEntity<String> generateTickets(@RequestBody GenerateTicketRequest gtr)
    {
        return new ResponseEntity<String>(voyageurService.generatetickets(gtr),HttpStatus.OK);
    }

    @GetMapping("/consulterTickets")
    public ResponseEntity<List<Eticket>> getMyTickets()
    {
        return new ResponseEntity<List<Eticket>>(voyageurService.getAllTickets(),HttpStatus.OK);
    }


}
