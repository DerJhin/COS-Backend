package com.cos.capybara.Skins;

import com.cos.capybara.Items.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skins")
@Getter
@Setter
public class Skin {

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @ManyToOne
    @JoinColumn(name = "itemName")
    private Item item;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "floatNumber")
    private double floatNumber;

    @Column(name = "floatString")
    private double floatString;

    @Column(name = "hasPattern")
    private boolean hasPattern;

    @Column(name = "patternNumber")
    private int patternNumber;

    @Column(name = "isStatTrak")
    private boolean isStatTrak;

}



