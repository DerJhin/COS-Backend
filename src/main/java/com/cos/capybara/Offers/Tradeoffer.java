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
@Table(name = "tradeoffer")
public class Tradeoffer {

    @Id
    @Column(name = "tradeoffer_id")
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
    private ArrayList<Item> itemsSender;

    @OneToMany
    @JoinColumn(name = "receiver_item_id")
    private ArrayList<Item> itemsReceiver;
}
