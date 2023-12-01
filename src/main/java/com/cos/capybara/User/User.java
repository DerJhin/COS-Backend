package com.cos.capybara.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "benutzer")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "benutzer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
