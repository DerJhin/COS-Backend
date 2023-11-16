package com.cos.capybara.Case;

import com.cos.capybara.Items.Item;
import com.cos.capybara.Random.RandomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/case")
public class CaseController {

    public final RandomService randomService;

    public final CaseService caseService;

    public CaseController(RandomService randomService, CaseService caseService) {
        this.randomService = randomService;
        this.caseService = caseService;
    }

    @GetMapping("/openCase/{caseName}")
    public Item openCase(@PathVariable String caseName) {
        return caseService.openCase(caseName);
    }
}
