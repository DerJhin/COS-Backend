package com.cos.capybara.Offers.Markt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarktRepository extends JpaRepository<Marktoffer, Long> {
}
