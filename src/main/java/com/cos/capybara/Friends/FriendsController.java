package com.cos.capybara.Friends;

import org.springframework.web.bind.annotation.RestController;

@RestController("/friends")
public class FriendsController {

    public final FriendsService friendsService;

    public FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }
}
