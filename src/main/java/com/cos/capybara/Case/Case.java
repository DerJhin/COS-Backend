package com.cos.capybara.Case;

import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.Skins.Rarity;
import com.cos.capybara.Skins.Skin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

import static com.cos.capybara.Skins.Rarity.*;

@Entity
@Table(name = "cases")
@Getter
@Setter
public class Case {

    @Id
    @Column(name = "case_name")
    private String name;

    @OneToMany(mappedBy = "weaponCase")
    private List<CaseSkin> caseSkins;

    @Column(name = "price")
    private String price;

    public Case(String name, List<Skin> skins) {
        this.name = name;
        this.caseSkins = createCaseSkins(skins);
    }

    public Case() {
    }

    private List<CaseSkin> createCaseSkins(List<Skin> skins){
        Map<Rarity, Double> probability = createProbability(skins);
        List<CaseSkin> caseSkins = new ArrayList<CaseSkin>();
        for(Skin toMathSkin : skins){
            caseSkins.add(new CaseSkin(toMathSkin, probability.get(toMathSkin.getRarity())));
        }
        System.out.println("Case:" + caseSkins.getLast().getSkin().getName() + caseSkins.getFirst().getSkin().getName());
        return caseSkins;
    }

    private Map<Rarity, Double> createProbability(List<Skin> skins) {
        Map<Rarity, Double> probability = new HashMap<>();
        probability.put(GOLD, createProbability(skins, GOLD, 0.0026));
        probability.put(RED, createProbability(skins, RED, 0.0064));
        probability.put(PINK, createProbability(skins, PINK, 0.032));
        probability.put(PURPLE, createProbability(skins, PURPLE, 0.1598));
        probability.put(BLUE, createProbability(skins, BLUE, 0.7992));
        return probability;
    }

    private double createProbability(List<Skin> skins, Rarity name, double probability) {
        double count = 0;
        for(Skin skin : skins) {
            if(skin.getRarity().equals(name)) {
                count++;
            }
        }
        return probability / count;
    }
}
