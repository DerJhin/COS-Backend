package com.cos.capybara.Case;

import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.CaseSkin.CaseSkinService;
import com.cos.capybara.Items.Item;
import com.cos.capybara.Items.ItemService;
import com.cos.capybara.Random.RandomService;
import com.cos.capybara.exeption.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CaseService implements DefaultCaseService {

    private final CaseRepository CaseRepository;

    private final RandomService randomService;

    private final ItemService itemService;

    private final CaseSkinService caseSkinService;

    public CaseService(com.cos.capybara.Case.CaseRepository caseRepository, RandomService randomService, ItemService itemService, CaseSkinService caseSkinService) {
        this.CaseRepository = caseRepository;
        this.randomService = randomService;
        this.itemService = itemService;
        this.caseSkinService = caseSkinService;
    }

    public Case getCase(String name){
        return CaseRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Case not found"));
    }

    public Item openCase(String caseName){
        Case weaponCase = getCase(caseName);
        return itemService.createAndSaveItem(randomService.getRandomSkin(weaponCase));
    }

    public Collection<CaseSkin> getSkinsOfCase(String caseName){
        Case weaponCase = getCase(caseName);
        return caseSkinService.findByWeaponCase(weaponCase);
    }
}
