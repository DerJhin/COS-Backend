package com.cos.capybara.Benutzer;

import com.cos.capybara.Benutzer.Inventory.Inventory;
import com.cos.capybara.Benutzer.Records.CreateBenutzer;
import com.cos.capybara.Benutzer.Records.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BenutzerService implements DefaultBenutzerService{

    private final BenutzerRepository benutzerRepository;

    public BenutzerService(BenutzerRepository benutzerRepository){
        this.benutzerRepository = benutzerRepository;
    }

    public Optional<Benutzer> getBenutzer(Long id){
        return benutzerRepository.getBenutzerById(id);
    }

    public Optional<Inventory> getInventar(Long id){
        return benutzerRepository.getBenutzerById(id)
                .map(Benutzer::getInventory);
    }

    public Profile getProfile(Long id) {
        return benutzerRepository.getBenutzerById(id)
                .map(benutzer -> new Profile(benutzer.getId(), benutzer.getUsername(), benutzer.getEmail(), benutzer.getBalance(), null))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + id));
    }

    public Benutzer createBenutzer(CreateBenutzer createBenutzer){
        Benutzer benutzer = new Benutzer(createBenutzer.username(), createBenutzer.email(), createBenutzer.profilePicture());
        return benutzerRepository.save(benutzer);
    }
}
