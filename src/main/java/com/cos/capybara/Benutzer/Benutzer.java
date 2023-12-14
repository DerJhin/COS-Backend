package com.cos.capybara.Benutzer;

import com.cos.capybara.Benutzer.Inventory.Inventory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
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

    @Lob
    @Column(name = "profilePicture")
    private Blob profilePicture;

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private int balance;

    public Benutzer(String username, String email, Blob profilePicture) {
        this.username = username;
        this.email = email;
        this.inventory = new Inventory();
        this.friends = new ArrayList<>();
        this.balance = 0;
        this.profilePicture = profilePicture;
    }

    public Benutzer() {

    }
}
