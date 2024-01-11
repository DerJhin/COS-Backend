package com.cos.capybara.Items;

import com.cos.capybara.Benutzer.Inventory.Inventory;
import com.cos.capybara.Skins.Skin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "skin_id")
    private Skin skin;

    @Column(name = "float_value")
    private double floatValue;

    @Column(name = "float_string")
    private String floatString;

    @Column(name = "is_stat_trak")
    private boolean isStatTrak;

    @Column(name = "pattern_number")
    private int patternNumber;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Item(Skin skin){
        this.skin = skin;
    }

    public Item() {
    }
}