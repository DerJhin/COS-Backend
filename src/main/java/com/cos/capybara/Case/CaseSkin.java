package com.cos.capybara.Case;

import com.cos.capybara.Skins.Skin;
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
    private Case weaponCase;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "skin_name", referencedColumnName = "name"),
            @JoinColumn(name = "skin_weapon_name", referencedColumnName = "weapon_name")
    })
    private Skin skin;

    @Column(name = "probability")
    private Double probability;

    public CaseSkin(Skin skin, double probability){
        this.skin = skin;
        this.probability = probability;
    }
    public CaseSkin() {
    }
}
