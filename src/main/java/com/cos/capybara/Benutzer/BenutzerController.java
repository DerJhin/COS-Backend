package com.cos.capybara.Benutzer;

import com.cos.capybara.exeption.BenutzerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/benutzer")
public class BenutzerController {

    private final BenutzerService benutzerService;

    public BenutzerController(BenutzerService benutzerService){
        this.benutzerService = benutzerService;
    }

    @GetMapping("/{id}")
    public Benutzer getBenutzer(@PathVariable Long id){
        return benutzerService.getBenutzer(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + id));
    }

    @GetMapping("/{id}/inventory")
    public Inventory getInventar(@PathVariable Long id){
        return benutzerService.getInventar(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + id));
    }

    @GetMapping("/profile/{id}")
    public Profile getProfile(@PathVariable Long id){
        return benutzerService.getProfile(id);
    }
}
