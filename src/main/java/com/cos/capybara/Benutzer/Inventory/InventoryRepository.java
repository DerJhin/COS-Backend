package com.cos.capybara.Benutzer.Inventory;

import com.cos.capybara.Benutzer.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
