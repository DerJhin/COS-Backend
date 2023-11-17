package com.cos.capybara.Case;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaseRepository extends JpaRepository<Case, String> {

    boolean existsByName(String name);

    Optional<Case> findByName(String name);

}
