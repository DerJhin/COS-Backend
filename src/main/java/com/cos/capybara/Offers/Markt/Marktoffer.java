package com.cos.capybara.Offers.Markt;

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

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "provider_item_id")
    private Item itemProvided;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Benutzer buyer;

    public Marktoffer(Benutzer provider, Item itemProvided, int price) {
        this.provider = provider;
        this.itemProvided = itemProvided;
        this.status = "open";
        this.buyer = null;
        this.price = price;
    }

    public Marktoffer() {
    }
}
