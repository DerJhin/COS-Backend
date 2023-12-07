package com.cos.capybara.Friends;

import com.cos.capybara.Benutzer.BenutzerRepository;
import com.cos.capybara.Benutzer.BenutzerService;
import com.cos.capybara.Benutzer.Records.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendsService implements DefaultFriendsService{

    private final BenutzerRepository benutzerRepository;

    private final BenutzerService benutzerService;

    public FriendsService(BenutzerRepository benutzerRepository, BenutzerService benutzerService){
        this.benutzerRepository = benutzerRepository;
        this.benutzerService = benutzerService;
    }

    public Optional<ArrayList<Profile>> getFriends(Long id){
        benutzerService.getBenutzer(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + id));;
        return benutzerRepository.getAllFriendsById(id)
                .map(friends -> (ArrayList<Profile>) friends.stream()
                        .map(benutzer -> new Profile(benutzer.getId(), benutzer.getUsername(), benutzer.getEmail(), benutzer.getBalance(), benutzer.getProfilePicture()))
                        .collect(Collectors.toList())
                );
    }
}
