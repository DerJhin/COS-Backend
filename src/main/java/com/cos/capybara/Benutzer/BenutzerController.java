package com.cos.capybara.Benutzer;

import com.cos.capybara.Benutzer.Inventory.Inventory;
import com.cos.capybara.Benutzer.Records.CreateBenutzer;
import com.cos.capybara.Benutzer.Records.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/createBenutzer")
    public Benutzer createBenutzer(@RequestBody CreateBenutzer createBenutzer){
        return benutzerService.createBenutzer(createBenutzer);
    }
}
