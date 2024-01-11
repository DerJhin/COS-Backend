package com.cos.capybara.Offers.Trade;

import com.cos.capybara.Benutzer.Benutzer;
import com.cos.capybara.Items.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "tradeoffer")
public class Tradeoffer {

    @Id
    @Column(name = "tradeoffer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Benutzer sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Benutzer receiver;

    @Column(name = "status")
    private String status;

    @OneToMany
    @JoinColumn(name = "sender_item_id")
    private List<Item> itemsSender;

    @OneToMany
    @JoinColumn(name = "receiver_item_id")
    private List<Item> itemsReceiver;

    public Tradeoffer(Benutzer sender, Benutzer receiver, String status, List<Item> itemsSender, List<Item> itemsReceiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
        this.itemsSender = itemsSender;
        this.itemsReceiver = itemsReceiver;
    }

    public Tradeoffer() {

    }
}
