package com.cos.capybara.Items;

import com.cos.capybara.RandomOrg.RandomOrgService;
import com.cos.capybara.Skins.Skin;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemService {

    public final RandomOrgService randomOrgService;

    public final ItemRepository itemRepository;

    public ItemService(RandomOrgService randomOrgService, ItemRepository itemRepository) {
        this.randomOrgService = randomOrgService;
        this.itemRepository = itemRepository;
    }

    public Optional<Item> getItem(Long id) {
        return itemRepository.getItemById(id);
    }

    public Item createAndSaveItem(Skin skin) {
        Item item = new Item(skin);
        item = applyFloat(item);
        item = applyStattrak(item);
        item = applyPattern(item);
        item.setDate(LocalDateTime.now());
        itemRepository.save(item);
        return item;
    }
    public Item applyFloat(Item item){
        double floatNumber = randomOrgService.generateDecimalFractionsForFloatSkin();
        item.setFloatValue(floatNumber);
        item.setFloatString(getFloatString(floatNumber));
        return item;
    }

    public Item applyStattrak(Item item){
        int stattrak = randomOrgService.generateIntegersForStattrak();
        item.setStatTrak(stattrak == 1);
        return item;
    }

    public Item applyPattern(Item item){
        if(skinHasPattern(item.getSkin())){
            int patternNumber = randomOrgService.generateIntegersForPattern();
            item.setPatternNumber(patternNumber);
        }
        return item;
    }

    private String getFloatString(double floatNumber){
        if(floatNumber < 0.07) {
            return "Factory New";
        }else if(floatNumber < 0.15) {
            return "Minimal Wear";
        }else if(floatNumber < 0.38) {
            return "Field-Tested";
        }else if(floatNumber < 0.45) {
            return "Well-Worn";
        }else {
            return "Battle-Scarred";
        }
    }

    public boolean skinHasPattern(Skin skin){
        return skin.isHasPattern();
    }
}
