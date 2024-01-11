package com.cos.capybara.Benutzer;

import com.cos.capybara.Benutzer.Records.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final BenutzerService benutzerService;

    public LoginController(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }

    @PostMapping()
    public Benutzer login(@RequestBody Login login){
        return benutzerService.login(login);
    }


}
