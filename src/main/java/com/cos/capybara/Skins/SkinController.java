package com.cos.capybara.Skins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/skin")
public class SkinController {

    public final SkinService skinService;

    public SkinController(SkinService skinService){
        this.skinService = skinService;
    }

    @GetMapping("/{id}")
    public Skin getSkin(@PathVariable Long id){
        return skinService.getSkin(id);
    }
}
