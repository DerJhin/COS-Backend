package com.cos.capybara.Friends;

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

    public FriendsController(FriendsService friendsService){
        this.friendsService = friendsService;
    }

    @GetMapping("/{id}")
    public List<Friend> getFriends(@PathVariable Long id){
        return friendsService.getFriends(id);
    }

    @PostMapping("/{id1}/{id2}")
    public void addFriend(@PathVariable Long id1, @PathVariable Long id2){
        friendsService.addFriend(id1, id2);
    }
}
