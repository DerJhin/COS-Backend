package com.cos.capybara.Case;

import com.cos.capybara.Benutzer.BenutzerService;
import com.cos.capybara.Case.Records.CaseRecord;
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

    public final BenutzerService benutzerService;

    public CaseController(RandomService randomService, CaseService caseService, BenutzerService benutzerService) {
        this.randomService = randomService;
        this.caseService = caseService;
        this.benutzerService = benutzerService;
    }

    @GetMapping("/openCase/{caseName}/{userId}")
    public Item openCase(@PathVariable String caseName, @PathVariable long userId) {
        Item item = caseService.openCase(caseName, userId);
        benutzerService.addToInventory(item, userId);
        return item;
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
    public Case createCase(@RequestBody CaseRecord caseRecord) {
        return caseService.createCase(caseRecord.skinIds(), caseRecord.name());
    }
}
