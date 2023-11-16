package com.cos.capybara.Skins;

import com.cos.capybara.Items.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
    @JoinColumn(name = "item_name")
    private Item item;

    @Column(name = "rarity")
    private String rarity;
}

