package com.cos.capybara.Profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/profile")
public class ProfileController {

    public final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public Profile openProfile(@PathVariable Long id) {
        return profileService.getProfile(id);
    }
}
