package com.cos.capybara.CaseSkin;

import com.cos.capybara.Case.Case;
import com.cos.capybara.Skins.Rarity;
import com.cos.capybara.Skins.Skin;
import com.cos.capybara.Skins.SkinService;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.cos.capybara.Skins.Rarity.*;
import static com.cos.capybara.Skins.Rarity.BLUE;

@Service
public class CaseSkinService {

    public final CaseSkinRepository caseSkinRepository;

    public final SkinService skinService;

    public CaseSkinService(CaseSkinRepository caseSkinRepository, SkinService skinService) {
        this.caseSkinRepository = caseSkinRepository;
        this.skinService = skinService;
    }

    public Optional<Collection<CaseSkin>> findByWeaponCase(Case weaponCase){
        return caseSkinRepository.getCaseSkinsByWeaponCaseEquals(weaponCase);
    }

    public void saveCaseToCaseSkins(List<CaseSkin> caseSkins, Case weaponCase){
        for(CaseSkin caseSkin : caseSkins){
            caseSkin.setWeaponCase(weaponCase);
        }
        caseSkinRepository.saveAll(caseSkins);
    }

    public List<CaseSkin> creatCaseSkinsById(List<Integer> skinIds){
        List<Skin> skins = skinService.getSkinsById(skinIds);
        Map<Rarity, Double> probability = createProbability(skins);
        List<CaseSkin> caseSkins = new ArrayList<CaseSkin>();
        for(Skin toMathSkin : skins){
            caseSkins.add(new CaseSkin(toMathSkin, probability.get(toMathSkin.getRarity())));
        }
        return caseSkinRepository.saveAll(caseSkins);
    }

    public void saveAll(List<CaseSkin> caseSkins){
        caseSkinRepository.saveAll(caseSkins);
    }

    private Map<Rarity, Double> createProbability(List<Skin> skins) {
        Map<Rarity, Double> probability = new HashMap<>();
        probability.put(GOLD, createProbability(skins, GOLD, 0.0026));
        probability.put(RED, createProbability(skins, RED, 0.0064));
        probability.put(PINK, createProbability(skins, PINK, 0.032));
        probability.put(PURPLE, createProbability(skins, PURPLE, 0.1598));
        probability.put(BLUE, createProbability(skins, BLUE, 0.7992));
        return probability;
    }

    private double createProbability(List<Skin> skins, Rarity name, double probability) {
        double count = 0;
        for(Skin skin : skins) {
            if(skin.getRarity().equals(name)) {
                count++;
            }
        }
        return probability / count;
    }
}
