package com.cos.capybara.Friends;

import com.cos.capybara.Benutzer.Benutzer;
import com.cos.capybara.Benutzer.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final FriendsService friendsService;

    public FriendsController(FriendsService friendsService){
        this.friendsService = friendsService;
    }

    @GetMapping("/{id}")
    public ArrayList<Profile> getFriends(@PathVariable Long id){
        return friendsService.getFriends(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Friends not found for User with id: " + id));
    }
}
