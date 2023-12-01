package com.cos.capybara.Friends;

import com.cos.capybara.Benutzer.Benutzer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final FriendsService friendsService;

    public FriendsController(FriendsService friendsService){
        this.friendsService = friendsService;
    }

    @GetMapping("/{id}")
    public ArrayList<Benutzer> getFriends(@PathVariable Long id){
        return friendsService.getFriends(id);
    }
}
