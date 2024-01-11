package com.cos.capybara.Offers.Markt;

import com.cos.capybara.Offers.Markt.Records.MarktofferCreate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marktoffer")
public class MarktController {

    private final MarktService marktService;

    public MarktController(MarktService marktService) {
        this.marktService = marktService;
    }

    @GetMapping
    public Iterable<Marktoffer> getMarktoffers() {
        return marktService.getMarktoffers();
    }

    @PostMapping("/create")
    public Marktoffer createMarktoffer(@RequestBody MarktofferCreate marktoffer) {
        return marktService.createMarktoffer(marktoffer);
    }

    @PostMapping("/buy/{id}/buyer/{buyerId}")
    public void buyMarktoffer(@PathVariable Long id, @PathVariable Long buyerId){
        marktService.buyMarktoffer(id, buyerId);
    }

    @PostMapping("/delete/{id}")
    public void deleteMarktoffer(@PathVariable Long id) {
        marktService.deleteMarktoffer(id);
    }
}
