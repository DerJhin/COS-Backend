package com.cos.capybara.CaseSkin;

import com.cos.capybara.Case.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CaseSkinRepository extends JpaRepository<CaseSkin, Long> {

    Optional<Collection<CaseSkin>> getCaseSkinsByWeaponCaseEquals(Case weaponCase);

}
