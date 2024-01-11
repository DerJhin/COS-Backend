package com.cos.capybara.Benutzer;

import com.cos.capybara.Benutzer.Inventory.Inventory;
import com.cos.capybara.Benutzer.Inventory.InventoryRepository;
import com.cos.capybara.Benutzer.Records.BenutzerSearch;
import com.cos.capybara.Benutzer.Records.CreateBenutzer;
import com.cos.capybara.Benutzer.Records.Login;
import com.cos.capybara.Benutzer.Records.Profile;
import com.cos.capybara.Items.Item;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BenutzerService implements DefaultBenutzerService{

    private final BenutzerRepository benutzerRepository;

    private final InventoryRepository inventoryRepository;

    public BenutzerService(BenutzerRepository benutzerRepository, InventoryRepository inventoryRepository){
        this.benutzerRepository = benutzerRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public Benutzer getBenutzer(Long id){
        return benutzerRepository.getBenutzerById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + id));
    }

    public Optional<Inventory> getInventar(Long id){
        return benutzerRepository.getBenutzerById(id)
                .map(Benutzer::getInventory);
    }

    public Profile getProfile(Long id) {
        return benutzerRepository.getBenutzerById(id)
                .map(benutzer -> new Profile(benutzer.getId(), benutzer.getUsername()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + id));
    }

    public Benutzer createBenutzer(CreateBenutzer createBenutzer){
        Benutzer benutzer = new Benutzer(createBenutzer.username(), createBenutzer.password());
        inventoryRepository.save(benutzer.getInventory());
        return benutzerRepository.save(benutzer);
    }

    public Benutzer login(Login loginInfo){
        java.util.Date currentDate = new java.util.Date();
        Benutzer benutzer = benutzerRepository.getBenutzerByUsername(loginInfo.username()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with username: " + loginInfo.username()));;
        if(benutzer.getPassword().equals(loginInfo.password())){
            System.out.println(LocalDate.now().isAfter(benutzer.getLastLogin().plusDays(1)));
            if(LocalDate.now().isAfter(benutzer.getLastLogin().plusDays(1))){
                benutzer.setBalance(benutzer.getBalance() + 100);
                benutzerRepository.save(benutzer);
            }
            return benutzer;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password does not match");
        }
    }

    public void addToInventory(Item item, long userId){
        Benutzer benutzer = benutzerRepository.getBenutzerById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + userId));
        Inventory inventory = benutzer.getInventory();
        if(null == inventory.getItems()){
            List<Item> items = new ArrayList<>();
            items.add(item);
            inventory.setItems(items);
        }else{
            List<Item> items= inventory.getItems();
            items.add(item);
            inventory.setItems(items);
        }
        inventoryRepository.save(inventory);
    }

    public void removeFromInventory(Item item, long userId){
        Benutzer benutzer = benutzerRepository.getBenutzerById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer not found with id: " + userId));
        Inventory inventory = benutzer.getInventory();
        if(null == inventory.getItems()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found in inventory");
        }else{
            List<Item> items= inventory.getItems();
            items.remove(item);
            inventory.setItems(items);
        }
        inventoryRepository.save(inventory);
    }

    public List<BenutzerSearch> searchBenutzer(String username){
        return benutzerRepository.getBenutzersByUsernameStartingWith(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No benutzer found with username: " + username))
                .stream()
                .map(benutzer -> new BenutzerSearch(benutzer.getId(), benutzer.getUsername()))
                .collect(Collectors.toList());
    }

    public Benutzer save(Benutzer benutzer){
        return benutzerRepository.save(benutzer);
    }
}
