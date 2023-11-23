package com.cos.capybara.Skins;

import org.springframework.stereotype.Service;

@Service
public class SkinService implements DefaultSkinService{

    private final SkinRepository skinRepository;

    public SkinService(SkinRepository skinRepository){
        this.skinRepository = skinRepository;
    }

    public Skin getSkin(Long id){
        return skinRepository.getReferenceById(id);
    }
}
