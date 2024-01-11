package com.cos.capybara.Offers.Trade;

import com.cos.capybara.Offers.Trade.Records.TradeofferCreate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trade")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping("/create")
    public Tradeoffer createTradeoffer(@RequestBody TradeofferCreate tradeofferCreate) {
        return tradeService.createTradeoffer(tradeofferCreate);
    }

    @PostMapping("/accept")
    public void acceptTradeoffer(@RequestBody TradeofferCreate tradeofferCreate) {
        tradeService.acceptTradeoffer(tradeofferCreate);
    }

    @PostMapping("/decline/{id}")
    public void declineTradeoffer(@PathVariable Long id) {
        tradeService.declineTradeoffer(id);
    }

    @PostMapping("/cancel")
    public void cancelTradeoffer(@PathVariable Long id) {
        tradeService.cancelTradeoffer(id);
    }

    @GetMapping("/get/{id}")
    public Tradeoffer getTradeoffer(@PathVariable Long id) {
        return tradeService.getTradeoffer(id);
    }

    @GetMapping("/getall/received/{id}")
    public Iterable<Tradeoffer> getTradeoffers(@PathVariable Long id) {
        return tradeService.getTradeoffers(id);
    }

    @GetMapping("/getall/sent/{id}")
    public Iterable<Tradeoffer> getTradeoffersSent(@PathVariable Long id) {
        return tradeService.getTradeoffersSent(id);
    }
}
