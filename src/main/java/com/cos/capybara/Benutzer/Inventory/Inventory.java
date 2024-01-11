package com.cos.capybara.Benutzer.Inventory;

import com.cos.capybara.Items.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory {

    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "items")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> items;
}
