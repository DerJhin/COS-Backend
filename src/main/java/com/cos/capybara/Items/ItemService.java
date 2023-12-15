package com.cos.capybara.Items;

import com.cos.capybara.Case.Case;
import com.cos.capybara.Random.RandomService;
import com.cos.capybara.RandomOrg.RandomOrgService;
import com.cos.capybara.Skins.Skin;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
public class ItemService {

    public final RandomOrgService randomOrgService;

    public final RandomService randomService;

    public final ItemRepository itemRepository;

    Random random = new Random();

    @Value("${api.use}")
    private boolean useApiToCreateNumbers;

    public ItemService(RandomOrgService randomOrgService, RandomService randomService, ItemRepository itemRepository) {
        this.randomOrgService = randomOrgService;
        this.randomService = randomService;
        this.itemRepository = itemRepository;
    }

    public Optional<Item> getItem(Long id) {
        return itemRepository.getItemById(id);
    }

    public Item createAndSaveItem(Case weaponCase) {
        ArrayList<Double> doubleValue = getDouble();
        ArrayList<Integer> integerValue = getInteger();
        Item item = new Item(randomService.getRandomSkin(weaponCase, doubleValue.get(0)));
        item = applyFloat(item, doubleValue.get(1));
        item = applyStattrak(item, integerValue.get(0));
        item = applyPattern(item, integerValue.get(1));
        item.setDate(LocalDateTime.now());
        itemRepository.save(item);
        return item;
    }
    public Item applyFloat(Item item, double floatNumber){
        item.setFloatValue(floatNumber);
        item.setFloatString(getFloatString(floatNumber));
        return item;
    }

    public Item applyStattrak(Item item, int stattrak){
        item.setStatTrak(stattrak >= 1 && stattrak <= 99);
        return item;
    }

    public Item applyPattern(Item item, int patternNumber){
        if(skinHasPattern(item.getSkin())){
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

    private ArrayList<Double> getDouble(){
        if(useApiToCreateNumbers){
         return randomOrgService.generateDecimalFractions();
        } else {
            ArrayList<Double> randomDoubleList = new ArrayList<>();
            randomDoubleList.add(random.nextDouble());
            randomDoubleList.add(random.nextDouble());

            return randomDoubleList;
        }
    }

    private ArrayList<Integer> getInteger(){
        if(useApiToCreateNumbers){
            return randomOrgService.generateIntegers();
        } else {
            ArrayList<Integer> randomIntegerList = new ArrayList<>();
            randomIntegerList.add(random.nextInt(999));
            randomIntegerList.add(random.nextInt(999));

            return randomIntegerList;
        }

    }
}
