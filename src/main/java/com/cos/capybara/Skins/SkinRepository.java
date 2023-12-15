package com.cos.capybara.Skins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkinRepository extends JpaRepository<Skin, Long> {
    Optional<Skin> findSkinById(int skinId);
}
