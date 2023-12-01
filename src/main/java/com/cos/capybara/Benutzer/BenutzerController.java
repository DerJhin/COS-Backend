package com.cos.capybara.Benutzer;

import com.cos.capybara.exeption.BenutzerNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benutzer")
public class BenutzerController {

    private final BenutzerService benutzerService;

    public BenutzerController(BenutzerService benutzerService){
        this.benutzerService = benutzerService;
    }

    @GetMapping("/{id}")
    public Benutzer getBenutzer(@PathVariable Long id){
        return benutzerService.getBenutzer(id).orElseThrow(BenutzerNotFoundException::new);
    }
}
