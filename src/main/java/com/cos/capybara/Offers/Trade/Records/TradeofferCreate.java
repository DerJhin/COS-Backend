package com.cos.capybara.Offers.Trade.Records;
import java.util.List;

public record TradeofferCreate(Long senderId, Long receiverId, String status, List<Long> itemsSender, List<Long> itemsReceiver) {
}
