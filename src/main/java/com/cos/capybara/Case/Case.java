package com.cos.capybara.Case;

import com.cos.capybara.Skins.Skin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "cases")
@Getter
@Setter
public class Case {


    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "case_skins",
            joinColumns = @JoinColumn(name = "case_name"),
            inverseJoinColumns = @JoinColumn(name = "skin_name", referencedColumnName = "name")
    )
    private Set<Skin> skins;

    @Column(name = "probability")
    @ElementCollection
    @MapKeyColumn(name = "rarity")
    private Map<String, Double> probability;


    public Case(String name, Set<Skin> skins) {
        this.name = name;
        this.skins = skins;
        this.probability = createProbability();
    }

    public Case() {
    }

    private Map<String, Double> createProbability() {
        Map<String, Double> probability = new HashMap<>();
        probability.put("gold", createProbability(skins, "gold", 0.0026));
        probability.put("red", createProbability(skins, "red", 0.0064));
        probability.put("pink", createProbability(skins, "pink", 0.032));
        probability.put("purple", createProbability(skins, "purple", 0.1598));
        probability.put("blue", createProbability(skins, "blue", 0.7992));
        return probability;
    }

    private double createProbability(Set<Skin> skins, String name, double probability) {
        double count = 0;
        for(Skin skin : skins) {
            if(skin.getRarity().equals(name)) {
                count++;
            }
        }
        return probability / count;
    }
}
