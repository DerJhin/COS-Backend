package com.cos.capybara.Skins;

import lombok.Getter;

@Getter
public enum Rarity {
    GREY(0), LIGHTBLUE(1), BLUE(2), PURPLE(3), PINK(4), RED(5), GOLD(6);

    private final int value;

    Rarity(int value) {
        this.value = value;
    }

}