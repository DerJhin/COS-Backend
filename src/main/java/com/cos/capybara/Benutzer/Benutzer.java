package com.cos.capybara.Benutzer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "benutzer")
@Getter
@Setter
public class Benutzer {

    @Id
    @Column(name = "benutzer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToMany
    @JoinColumn(name = "benutzer_id")
    private ArrayList<Benutzer> friends;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    //BLOB

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private int balance;
}
