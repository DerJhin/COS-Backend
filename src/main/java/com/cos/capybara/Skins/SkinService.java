package com.cos.capybara.Skins;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkinService implements DefaultSkinService{

    private final SkinRepository skinRepository;

    public SkinService(SkinRepository skinRepository) {
        this.skinRepository = skinRepository;
    }

    public List<Skin> getSkinsById(List<Integer> skinIDs) {
        List<Skin> skins = new ArrayList<>();
        for (Integer skinID : skinIDs) {
            if (skinID < 0) {
                throw new IllegalArgumentException("Skin ID cannot be negative");
            }
            skins.add(skinRepository.findSkinById(skinID).orElseThrow(() ->
                    new IllegalArgumentException("Skin with ID: " + skinID + " not found.")
            ));
        }
        System.out.print("getSkins" + skins.getLast().getName() + skins.getFirst().getName());
        return skins;
    }
}
