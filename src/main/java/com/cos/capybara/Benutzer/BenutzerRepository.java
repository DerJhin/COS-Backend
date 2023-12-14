package com.cos.capybara.Benutzer;

import com.cos.capybara.Benutzer.Inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {
    Optional<ArrayList<Benutzer>> getAllFriendsById(Long id);

    Optional<Benutzer> getBenutzerById(Long id);

    Optional<Inventory> getInventoryByInventoryId(Long id);
}
