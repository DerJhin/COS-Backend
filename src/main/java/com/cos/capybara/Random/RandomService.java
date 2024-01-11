package com.cos.capybara.Random;

import com.cos.capybara.Case.Case;
import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.Skins.Skin;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class RandomService implements DefaultRandomService{

    public final String CUMULATIVE_PROBABILITY_ERROR = "The probability of the case is not 100% or the target probability is not between 0 and 1";

    /**
     * Retrieves a random skin from the given weapon case based on target probability.
     *
     * @param weaponCase The weapon case to select a skin from.
     * @param targetProbability The target probability used to determine which skin to select.
     * @return The randomly selected skin from the weapon case.
     * @throws ResponseStatusException if the cumulative probability of the case is not 100% or
     *                                if the target probability is not between 0 and 1.
     */
    @Override
    public Skin getRandomSkin(Case weaponCase, double targetProbability) {
        System.out.println(targetProbability);
        double cumulativeProbability = 0;
        List<CaseSkin> caseSkins = weaponCase.getCaseSkins();
        for (CaseSkin skinCase : caseSkins) {
            cumulativeProbability += skinCase.getProbability();
            if (cumulativeProbability >= targetProbability) {
                return skinCase.getSkin();
            }
            ;
        }
        throw throwError(HttpStatus.CONFLICT, CUMULATIVE_PROBABILITY_ERROR);
    }

    private ResponseStatusException throwError(HttpStatus status, String message) {
        return new ResponseStatusException(status, message);
    }
}
