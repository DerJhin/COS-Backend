package com.cos.capybara.Items;

import com.cos.capybara.Skins.Skin;
import org.springframework.stereotype.Service;

@Service
public interface DefaultItemService {

    public Item createItem(Skin skin);

    public Item applyFloat(Item item);

    public Item applyStattrak(Item item);

    public Item applyPattern(Item item);
}
