package com.cos.capybara.Random;

import com.cos.capybara.Case.Case;
import com.cos.capybara.RandomOrg.RandomOrgService;
import com.cos.capybara.Skins.Skin;
import org.springframework.stereotype.Service;

@Service
public class RandomService implements DefaultRandomService{

    private final RandomOrgService randomOrgService;

    public RandomService(RandomOrgService randomOrgService) {
        this.randomOrgService = randomOrgService;
    }

    public double getRandomSkin() {
       return randomOrgService.generateRandomInteger();
    }
}
