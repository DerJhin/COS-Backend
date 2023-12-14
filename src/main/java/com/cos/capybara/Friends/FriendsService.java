package com.cos.capybara.Friends;

import com.cos.capybara.Benutzer.Benutzer;
import com.cos.capybara.Benutzer.BenutzerRepository;
import com.cos.capybara.Benutzer.BenutzerService;
import com.cos.capybara.exeption.BenutzerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FriendsService implements DefaultFriendsService{

    private final BenutzerRepository benutzerRepository;

    private final BenutzerService benutzerService;

    public FriendsService(BenutzerRepository benutzerRepository, BenutzerService benutzerService){
        this.benutzerRepository = benutzerRepository;
        this.benutzerService = benutzerService;
    }

    public ArrayList<Benutzer> getFriends(Long id){
        benutzerService.getBenutzer(id).orElseThrow(BenutzerNotFoundException::new);
        return benutzerRepository.getAllFriendsById(id).orElse(null);
    }
}
