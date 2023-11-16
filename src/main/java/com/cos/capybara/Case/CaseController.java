package com.cos.capybara.Case;

import com.cos.capybara.Random.RandomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/case")
public class CaseController {

    public final RandomService randomService;

    public final CaseService caseService;

    public CaseController(RandomService randomService, CaseService caseService) {
        this.randomService = randomService;
        this.caseService = caseService;
    }

    @GetMapping("/openCase")
    public String openCase() {
        Case weaponCase = caseService.getCase("TestCase");
        return randomService.getRandomSkin(weaponCase).getName();
    }
}
