package com.cos.capybara.Offers.Trade;

import com.cos.capybara.Benutzer.Benutzer;
import com.cos.capybara.Benutzer.BenutzerService;
import com.cos.capybara.Items.Item;
import com.cos.capybara.Items.ItemService;
import com.cos.capybara.Offers.Trade.Records.TradeofferCreate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;

@Service
public class TradeService {

    private final TradeRepositroy tradeRepositroy;

    private final BenutzerService benutzerService;

    private final ItemService itemService;

    public TradeService(TradeRepositroy tradeRepositroy, BenutzerService benutzerService, ItemService itemService) {
        this.tradeRepositroy = tradeRepositroy;
        this.benutzerService = benutzerService;
        this.itemService = itemService;
    }

    private record CheckForTradeOffer(List<Item> itemsSender, List<Item> itemsReceiver, Benutzer sender, Benutzer receiver) {
    }

    public Tradeoffer createTradeoffer(TradeofferCreate tradeofferCreate) {
        CheckForTradeOffer result = getCheckForTradeOffer(tradeofferCreate);
        Tradeoffer tradeoffer = new Tradeoffer(result.sender(), result.receiver(), tradeofferCreate.status(), result.itemsSender(), result.itemsReceiver());
        return tradeRepositroy.save(tradeoffer);
    }

    public void declineTradeoffer(Long id) {
        Tradeoffer tradeoffer = tradeRepositroy.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tradeoffer not found with id: " + id));
        tradeRepositroy.delete(tradeoffer);
    }

    public void cancelTradeoffer(Long id) {
        Tradeoffer tradeoffer = tradeRepositroy.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tradeoffer not found with id: " + id));
        tradeRepositroy.delete(tradeoffer);
    }

    public Tradeoffer getTradeoffer(Long id) {
        return tradeRepositroy.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tradeoffer not found with id: " + id));
    }

    public Iterable<Tradeoffer> getTradeoffers(Long id) {
        return tradeRepositroy.findAllByReceiverId(id);
    }

    public Iterable<Tradeoffer> getTradeoffersSent(Long id) {
        return tradeRepositroy.findAllBySenderId(id);
    }

    public void acceptTradeoffer(Long id) {
        Tradeoffer tradeoffer = tradeRepositroy.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tradeoffer not found with id: " + id));
        CheckForTradeOffer result = getCheckForTradeOffer(tradeoffer.getItemsSender(), tradeoffer.getItemsReceiver(), tradeoffer.getSender(), tradeoffer.getReceiver());

        benutzerService.removeFromInventory(result.itemsSender, result.sender);
        benutzerService.removeFromInventory(result.itemsReceiver, result.receiver);

        benutzerService.addToInventory(result.itemsSender, result.receiver);
        benutzerService.addToInventory(result.itemsReceiver, result.sender);

        tradeRepositroy.delete(tradeoffer);
    }

    private void checkItems(List<Item> itemsSender, List<Item> itemsReceiver, Benutzer sender, Benutzer receiver) {
        if (!new HashSet<>(sender.getInventory().getItems()).containsAll(itemsSender))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sender does not own item");
        if (!new HashSet<>(receiver.getInventory().getItems()).containsAll(itemsReceiver))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Receiver does not own item");
    }

    private CheckForTradeOffer getCheckForTradeOffer(TradeofferCreate tradeofferCreate) {
        List<Item> itemsSender = itemService.findAllById(tradeofferCreate.itemsSender());
        List<Item> itemsReceiver = itemService.findAllById(tradeofferCreate.itemsReceiver());
        Benutzer sender = benutzerService.getBenutzer(tradeofferCreate.senderId());
        Benutzer receiver = benutzerService.getBenutzer(tradeofferCreate.receiverId());
        checkItems(itemsSender, itemsReceiver, sender, receiver);
        CheckForTradeOffer result = new CheckForTradeOffer(itemsSender, itemsReceiver, sender, receiver);
        return result;
    }

    private CheckForTradeOffer getCheckForTradeOffer(List<Item> itemsSender, List<Item> itemsReceiver, Benutzer sender, Benutzer receiver) {
        checkItems(itemsSender, itemsReceiver, sender, receiver);
        CheckForTradeOffer result = new CheckForTradeOffer(itemsSender, itemsReceiver, sender, receiver);
        return result;
    }


}
