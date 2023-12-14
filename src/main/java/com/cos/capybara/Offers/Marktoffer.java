package com.cos.capybara.Offers;

import com.cos.capybara.Benutzer.Benutzer;
import com.cos.capybara.Items.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@Table(name = "marktoffer")
public class Marktoffer {

    @Id
    @Column(name = "marktoffer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Benutzer provider;

    @Column(name = "status")
    private String status;

    @OneToMany
    @JoinColumn(name = "provider_item_id")
    private ArrayList<Item> itemProvider;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Benutzer buyer;
}
