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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_name")
    @JsonBackReference
    private Case weaponCase;

    @ManyToOne
    @JoinColumn(name = "skin_id")
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
