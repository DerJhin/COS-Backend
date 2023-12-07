package com.cos.capybara.Case;

import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.Items.Item;
import com.cos.capybara.Random.RandomService;
import com.cos.capybara.Skins.Skin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/case")
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

    @GetMapping("/getSkinsForCase/{caseName}")
    public Collection<CaseSkin> getSkins(@PathVariable String caseName) {
        return caseService.getSkinsOfCase(caseName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Skins found for case: " + caseName));
    }

    @GetMapping("/getAllCases")
    public Collection<String> getAllCases() {
        return caseService.getAllCases();
    }

    @PostMapping("/createCase")
    public Case createCase(@RequestBody List<Skin> skins , @RequestBody String caseName) {
        return caseService.createCase(skins, caseName);
    }
}
