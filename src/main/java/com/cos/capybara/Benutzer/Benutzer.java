package com.cos.capybara.Benutzer;

import com.cos.capybara.Benutzer.Inventory.Inventory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    @JoinTable(name = "friendship",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<Benutzer> friends = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "inventory_id")
    @JsonBackReference
    private Inventory inventory;

    // @Lob
    // @Column(name = "profilePicture")
    // private Blob profilePicture;

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private int balance;

    @Column(name="password")
    @JsonIgnore
    private String password;

    public Benutzer(String username, String password) {
        this.username = username;
        this.email = email;
        this.inventory = new Inventory();
        this.friends = new ArrayList<>();
        this.balance = 0;
        // this.profilePicture = profilePicture;
        this.password = password;
    }

    public Benutzer() {

    }
}
