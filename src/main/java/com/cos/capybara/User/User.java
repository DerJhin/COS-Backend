package com.cos.capybara.User;

import com.cos.capybara.Friends.Friends;
import com.cos.capybara.Inventory.Inventory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "friends")
    @ManyToOne
    @JoinColumn(name = "username")
    @JsonBackReference
    private Friends friends;

    @Column(name = "inventory")
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Inventory inventory;

    //profilePicture BLOB

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private int balance;
}
