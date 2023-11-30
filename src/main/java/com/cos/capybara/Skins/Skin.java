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
public class Skin {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "weapon_name")
    @JsonBackReference
    private Weapon weapon;

    @Column(name = "has_pattern")
    private boolean hasPattern;

    @Column(name = "rarity")
    private Rarity rarity;

    //BLOB
}

