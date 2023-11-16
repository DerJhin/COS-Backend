package com.cos.capybara.CaseSkin;

import com.cos.capybara.Case.Case;
import com.cos.capybara.exeption.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CaseSkinService {

    public final CaseSkinRepository caseSkinRepository;

    public CaseSkinService(CaseSkinRepository caseSkinRepository) {
        this.caseSkinRepository = caseSkinRepository;
    }

    public Collection<CaseSkin> findByWeaponCase(Case weaponCase){
        System.out.println(weaponCase);
        System.out.println(caseSkinRepository.getCaseSkinsByWeaponCaseEquals(weaponCase));
        return caseSkinRepository.getCaseSkinsByWeaponCaseEquals(weaponCase).orElseThrow(() -> new EntityNotFoundException("No Skins found"));
    }
}
