package com.cos.capybara.Skins;

import com.cos.capybara.Weapons.Weapon;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skins")
@Getter
@Setter
@IdClass(SkinId.class)
public class Skin {

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @ManyToOne
    @JoinColumn(name = "weapon_name")
    @JsonBackReference
    private Weapon weapon;

    @Column(name = "has_pattern")
    private boolean hasPattern;

    @Column(name = "rarity")
    private String rarity;
}

