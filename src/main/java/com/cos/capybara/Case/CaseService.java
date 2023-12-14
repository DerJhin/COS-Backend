package com.cos.capybara.Case;

import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.CaseSkin.CaseSkinRepository;
import com.cos.capybara.CaseSkin.CaseSkinService;
import com.cos.capybara.Items.Item;
import com.cos.capybara.Items.ItemService;
import com.cos.capybara.Random.RandomService;
import com.cos.capybara.Skins.Skin;
import com.cos.capybara.Skins.SkinService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CaseService implements DefaultCaseService {

    private final CaseRepository CaseRepository;

    private final RandomService randomService;

    private final ItemService itemService;

    private final CaseSkinService caseSkinService;

    private final CaseSkinRepository CaseSkinRepository;

    public CaseService(com.cos.capybara.Case.CaseRepository caseRepository, RandomService randomService, ItemService itemService, CaseSkinService caseSkinService, SkinService skinService, com.cos.capybara.CaseSkin.CaseSkinRepository caseSkinRepository) {
        this.CaseRepository = caseRepository;
        this.randomService = randomService;
        this.itemService = itemService;
        this.caseSkinService = caseSkinService;
        this.CaseSkinRepository = caseSkinRepository;
    }

    public Case getCase(String name){
        return CaseRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Case not found with name: " + name));
    }

    public Item openCase(String caseName){
        Case weaponCase = getCase(caseName);
        if (weaponCase.getCaseSkins().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Skins found for case: " + caseName);
        }
        return itemService.createAndSaveItem(randomService.getRandomSkin(weaponCase));
    }

    public Optional<Collection<CaseSkin>> getSkinsOfCase(String caseName){
        Case weaponCase = getCase(caseName);
        return caseSkinService.findByWeaponCase(weaponCase);
    }

    public Case createCase(List<Integer> skinIds, String caseName){
        List<CaseSkin> caseSkins = caseSkinService.creatCaseSkinsById(skinIds);
        Case caseToCreate = new Case(caseName, caseSkins);
        Case caseAfterSearch = CaseRepository.save(caseToCreate);
        caseSkinService.saveCaseToCaseSkins(caseSkins, caseAfterSearch);
        return caseAfterSearch;
    }

    public Collection<String> getAllCases() {
        return CaseRepository.findAll().stream().map(Case::getName).toList();
    }

    public void save(Case weaponCase){
        CaseRepository.save(weaponCase);
    }
}
