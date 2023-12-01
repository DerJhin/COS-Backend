package com.cos.capybara.Benutzer;

import com.cos.capybara.Friends.Friends;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    @OneToOne
    @JoinColumn(name = "friends_id")
    private Friends friends;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    //BLOB

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private int balance;
}
