package com.cos.capybara.Benutzer;

import org.springframework.stereotype.Service;

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
}
