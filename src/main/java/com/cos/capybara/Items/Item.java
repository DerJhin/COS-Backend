package com.cos.capybara.Items;

import com.cos.capybara.Skins.Skin;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "items")
public class Item {

    //TODO@JSE: Need to add Inventory Field

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "skin_name", referencedColumnName = "name"),
            @JoinColumn(name = "skin_weapon_name", referencedColumnName = "weapon_name")
    })
    private Skin skin;

    @Column(name = "float_value")
    private double floatValue;

    @Column(name = "float_string")
    private String floatString;

    @Column(name = "is_stat_trak")
    private boolean isStatTrak;

    @Column(name = "pattern_number")
    private int patternNumber;

    public Item(Skin skin){
        this.skin = skin;
    }

    public Item() {
    }
}
