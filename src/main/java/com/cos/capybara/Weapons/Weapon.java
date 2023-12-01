package com.cos.capybara.Weapons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "weapons")
@Getter
@Setter
public class Weapon {

    @Id
    @Column(name = "weapon_name")
    private String name;

}
