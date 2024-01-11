package com.cos.capybara.Offers.Markt;

import com.cos.capybara.Benutzer.Benutzer;
import com.cos.capybara.Benutzer.BenutzerService;
import com.cos.capybara.Items.ItemService;
import com.cos.capybara.Offers.Markt.Records.MarktofferCreate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MarktService {

    private final MarktRepository marktRepository;

    private final BenutzerService benutzerService;

    private final ItemService itemService;

    public MarktService(MarktRepository marktRepository, BenutzerService benutzerService, ItemService itemService) {
        this.marktRepository = marktRepository;
        this.benutzerService = benutzerService;
        this.itemService = itemService;
    }

    public Iterable<Marktoffer> getMarktoffers() {
        return marktRepository.findAll();
    }

    public Marktoffer createMarktoffer(MarktofferCreate marktofferCreate) {
        if (!benutzerService.getBenutzer(marktofferCreate.benutzerId()).getInventory().getItems().contains(itemService.getItem(marktofferCreate.itemId())))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Benutzer does not own item");
        benutzerService.removeFromInventory(itemService.getItem(marktofferCreate.itemId()), marktofferCreate.benutzerId());
        Marktoffer marktoffer = new Marktoffer(benutzerService.getBenutzer(marktofferCreate.benutzerId()), itemService.getItem(marktofferCreate.itemId()), marktofferCreate.price());
        return  marktRepository.save(marktoffer);
    }

    public void buyMarktoffer(Long id, Long buyerId) {
        Marktoffer marktoffer = marktRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marktoffer not found with id: " + id));
        if(benutzerService.getBenutzer(buyerId).getBalance() < marktoffer.getPrice())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough money");
        Benutzer buyer = benutzerService.getBenutzer(buyerId);
        Benutzer provider = marktoffer.getProvider();
        if(provider.equals(buyer))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can't buy your own item");
        buyer.setBalance(buyer.getBalance() - marktoffer.getPrice());
        provider.setBalance(provider.getBalance() + marktoffer.getPrice());
        benutzerService.addToInventory(marktoffer.getItemProvided(), buyerId);
        benutzerService.save(buyer);
        benutzerService.save(provider);
        marktRepository.deleteById(id);
    }

    public void deleteMarktoffer(Long id) {
        Marktoffer marktoffer = marktRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marktoffer not found with id: " + id));
        benutzerService.addToInventory(marktoffer.getItemProvided(), marktoffer.getProvider().getId());
        marktRepository.deleteById(id);
    }
}
