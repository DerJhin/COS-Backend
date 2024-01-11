package com.cos.capybara.Offers.Trade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TradeRepositroy extends JpaRepository<Tradeoffer, Long> {
    Iterable<Tradeoffer> findAllByReceiverId(Long id);

    Iterable<Tradeoffer> findAllBySenderId(Long id);
}
