package com.cos.capybara.Friends;

import com.cos.capybara.Benutzer.Benutzer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "friends")
@Getter
@Setter
public class Friends {

    @Id
    @Column(name ="friends_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "benutzer_id")
    @OneToMany
    private ArrayList<Benutzer> username;
}