package com.cos.capybara.CaseSkin;

import com.cos.capybara.Case.Case;
import com.cos.capybara.Skins.Skin;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "case_skins")
public class CaseSkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_name")
    @JsonBackReference
    private Case weaponCase;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "skin_name", referencedColumnName = "name"),
            @JoinColumn(name = "skin_weapon_name", referencedColumnName = "weapon_name")
    })
    @JsonBackReference
    private Skin skin;

    @Column(name = "probability")
    private double probability;

    public CaseSkin(Skin skin, double probability){
        this.skin = skin;
        this.probability = probability;
    }
    public CaseSkin() {
    }
}
