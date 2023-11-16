package com.cos.capybara.Case;

import com.cos.capybara.Items.Item;
import com.cos.capybara.Items.ItemService;
import com.cos.capybara.Random.RandomService;
import com.cos.capybara.exeption.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CaseService implements DefaultCaseService {

    private final CaseRepository CaseRepository;

    private final RandomService randomService;

    private final ItemService itemService;

    public CaseService(com.cos.capybara.Case.CaseRepository caseRepository, RandomService randomService, ItemService itemService) {
        this.CaseRepository = caseRepository;
        this.randomService = randomService;
        this.itemService = itemService;
    }

    public Case getCase(String name){
        return CaseRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Case not found"));
    }

    public Item openCase(String caseName){
        Case weaponCase = getCase(caseName);
        return itemService.createAndSaveItem(randomService.getRandomSkin(weaponCase));
    }
}
