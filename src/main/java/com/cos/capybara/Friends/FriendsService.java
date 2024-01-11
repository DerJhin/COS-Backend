package com.cos.capybara.Friends;

import com.cos.capybara.Benutzer.Benutzer;
import com.cos.capybara.Benutzer.BenutzerRepository;
import com.cos.capybara.Benutzer.BenutzerService;
import com.cos.capybara.Benutzer.Records.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public List<Friend> getFriends(Long id){
        Benutzer benutzer = benutzerService.getBenutzer(id);
        List<Friend> friends= new ArrayList<>();
        for(Benutzer friendBenutzer : benutzer.getFriends()) {
            friends.add(new Friend(friendBenutzer.getId(), friendBenutzer.getUsername()));
        }
        return friends;
    }

    public void addFriend(Long id1, Long id2){
        if(Objects.equals(id1, id2)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Benutzer can not add itself as a friend");
        }
        Benutzer benutzer1 = benutzerService.getBenutzer(id1);
        Benutzer benutzer2 = benutzerService.getBenutzer(id2);
        List<Benutzer> friend1 = benutzer1.getFriends();
        List<Benutzer> friend2 = benutzer2.getFriends();
        friend1.add(benutzer2);
        friend2.add(benutzer1);
        benutzerRepository.save(benutzer1);
        benutzerRepository.save(benutzer2);
    }
}
