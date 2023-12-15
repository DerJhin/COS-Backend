package com.cos.capybara.Case;

import com.cos.capybara.CaseSkin.CaseSkin;
import com.cos.capybara.Skins.Rarity;
import com.cos.capybara.Skins.Skin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

import static com.cos.capybara.Skins.Rarity.*;

@Entity
@Table(name = "cases")
@Getter
@Setter
public class Case {

    @Id
    @Column(name = "case_name")
    private String name;

    @OneToMany(mappedBy = "weaponCase")
    private List<CaseSkin> caseSkins;

    @Column(name = "price")
    private String price;

    public Case(String name, List<CaseSkin> skins) {
        this.name = name;
        this.caseSkins = skins;
    }

    public Case() {
    }
}
