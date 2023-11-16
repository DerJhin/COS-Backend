package com.cos.capybara.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

    private final DefaultRandomService randomService;

    public RandomController(DefaultRandomService randomService) {
        this.randomService = randomService;
    }
    @GetMapping("/random")
    public double getRandom() {
        return randomService.getRandomSkin();
    }
}
