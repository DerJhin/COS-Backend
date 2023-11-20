package com.cos.capybara.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "currency")
@Getter
@Setter
public class Currency {

    @Id
    @Column(name="name")
    private String name;

}
