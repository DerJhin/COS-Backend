package com.cos.capybara.Profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/profile")
public class ProfilController {



    @GetMapping("/{id}")
    public Profile openProfile(@PathVariable Long id) {
        return
    }
}
