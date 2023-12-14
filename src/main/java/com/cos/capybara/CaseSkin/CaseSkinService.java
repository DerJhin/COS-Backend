package com.cos.capybara.CaseSkin;

import com.cos.capybara.Case.Case;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CaseSkinService {

    public final CaseSkinRepository caseSkinRepository;

    public CaseSkinService(CaseSkinRepository caseSkinRepository) {
        this.caseSkinRepository = caseSkinRepository;
    }

    public Optional<Collection<CaseSkin>> findByWeaponCase(Case weaponCase){
        return caseSkinRepository.getCaseSkinsByWeaponCaseEquals(weaponCase);
    }

    public void saveAll(List<CaseSkin> caseSkins){
        caseSkinRepository.saveAll(caseSkins);
    }
}
