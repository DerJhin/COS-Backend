package com.cos.capybara.Random;

import com.cos.capybara.Case.Case;
import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.RandomOrg.RandomOrgService;
import com.cos.capybara.Skins.Skin;
import org.springframework.data.repository.query.ParameterOutOfBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.w3c.dom.ranges.RangeException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomService implements DefaultRandomService{

    public Skin getRandomSkin(Case weaponCase, double randomDouble){
        double cumulativeProbability = 0;
        for (CaseSkin skin : weaponCase.getCaseSkins()) {
            cumulativeProbability += skin.getProbability();
            if (cumulativeProbability >= randomDouble) {
                return skin.getSkin();
            };
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "The probability of the case is not 100% or the random number is not between 0 and 1");
    }
}
