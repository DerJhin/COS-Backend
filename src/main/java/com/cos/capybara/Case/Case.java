package com.cos.capybara.Case;

import com.cos.capybara.Skins.Skin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "cases")
@Getter
@Setter
public class Case {


    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "weaponCase")
    private List<CaseSkin> caseSkins;

    public Case(String name, List<Skin> skins) {
        this.name = name;
        this.caseSkins = createCaseSkins(skins);
    }

    public Case() {
    }

    private List<CaseSkin> createCaseSkins(List<Skin> skins){
        Map<String, Double> probability = createProbability(skins);
        List<CaseSkin> caseSkin = new ArrayList<CaseSkin>();
        for(Skin toMathSkin : skins){
            caseSkin.add(new CaseSkin(toMathSkin, probability.get(toMathSkin.getRarity())));
        }
        return caseSkin;
    }

    private Map<String, Double> createProbability(List<Skin> skins) {
        Map<String, Double> probability = new HashMap<>();
        probability.put("gold", createProbability(skins, "gold", 0.0026));
        probability.put("red", createProbability(skins, "red", 0.0064));
        probability.put("pink", createProbability(skins, "pink", 0.032));
        probability.put("purple", createProbability(skins, "purple", 0.1598));
        probability.put("blue", createProbability(skins, "blue", 0.7992));
        return probability;
    }

    private double createProbability(List<Skin> skins, String name, double probability) {
        double count = 0;
        for(Skin skin : skins) {
            if(skin.getRarity().equals(name)) {
                count++;
            }
        }
        return probability / count;
    }
}
