package com.cos.capybara.Case;

import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.Items.Item;
import com.cos.capybara.Random.RandomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @GetMapping("/getSkins/{caseName}")
    public Collection<CaseSkin> getSkins(@PathVariable String caseName) {
        Collection<CaseSkin> caseSkins = caseService.getSkinsOfCase(caseName);
        System.out.println(caseSkins.size());
        return caseSkins;
    }
}
