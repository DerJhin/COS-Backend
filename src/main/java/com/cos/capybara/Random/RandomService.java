package com.cos.capybara.Random;

import com.cos.capybara.Case.Case;
import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.RandomOrg.RandomOrgService;
import com.cos.capybara.Skins.Skin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomService implements DefaultRandomService{

    private final RandomOrgService randomOrgService;

    public RandomService(RandomOrgService randomOrgService) {
        this.randomOrgService = randomOrgService;
    }

    public Skin getRandomSkin(Case weaponCase) {
        double randomDouble = randomOrgService.generateDecimalFractionsForRandomSkin();
        List<Double> cumulativeProbabilities = new ArrayList<>();
        double cumulativeProbability = 0;
        for (CaseSkin skin : weaponCase.getCaseSkins()) {
            cumulativeProbability += skin.getProbability();
            cumulativeProbabilities.add(cumulativeProbability);
        }
        int selectedIndex = -1;
        for (int i = 0; i < cumulativeProbabilities.size(); i++) {
            if (cumulativeProbabilities.get(i) >= randomDouble) {
                selectedIndex = i;
                break;
            }
        }
        return weaponCase.getCaseSkins().get(selectedIndex).getSkin();
    }
}
