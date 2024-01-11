package com.cos.capybara.Friends;

import com.cos.capybara.Benutzer.BenutzerService;
import com.cos.capybara.Benutzer.Records.BenutzerSearch;
import com.cos.capybara.Benutzer.Records.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final FriendsService friendsService;

    private final BenutzerService benutzerService;

    public FriendsController(FriendsService friendsService, BenutzerService benutzerService){
        this.friendsService = friendsService;
        this.benutzerService = benutzerService;
    }

    @GetMapping("/{id}")
    public List<Friend> getFriends(@PathVariable Long id){
        return friendsService.getFriends(id);
    }

    @PostMapping("/{id1}/{id2}")
    public void addFriend(@PathVariable Long id1, @PathVariable Long id2){
        friendsService.addFriend(id1, id2);
    }

    @GetMapping("/search/{username}")
    public List<BenutzerSearch> searchBenutzer(@PathVariable String username){
        return benutzerService.searchBenutzer(username);
    }
}
