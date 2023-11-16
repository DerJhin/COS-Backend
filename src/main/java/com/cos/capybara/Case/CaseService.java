package com.cos.capybara.Case;

import com.cos.capybara.exeption.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CaseService implements DefaultCaseService {

    private final CaseRepository CaseRepository;

    public CaseService(com.cos.capybara.Case.CaseRepository caseRepository) {
        CaseRepository = caseRepository;
    }

    public Case getCase(String name){
        return CaseRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Case not found"));
    }
}
