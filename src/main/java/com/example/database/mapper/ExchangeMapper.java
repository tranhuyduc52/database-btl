package com.example.database.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ExchangeRequest;
import com.example.database.dto.respone.ExchangeResponse;
import com.example.database.model.Exchange;
import com.example.database.repository.CustomerRepo;
import com.example.database.repository.GiftRepo;

@Service
public class ExchangeMapper {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired 
    private GiftRepo giftRepo;

    public ExchangeResponse tExchangeResponseDto(Exchange exchange){
        return new ExchangeResponse(exchange.getQuantity(),exchange.getDate(),exchange.getCustomer().getName(),exchange.getGift().getName());
    }
    public Exchange tExchange(ExchangeRequest dto,String phoneNumber){
        var exchange = new Exchange();
        exchange.setDate(dto.date());
        exchange.setQuantity(dto.quantity());
        var gift = giftRepo.findById(dto.giftId()).orElse(null);
        gift.addExchange(exchange);
        var customer = customerRepo.findByPhoneNumber(phoneNumber);
        customer.addExchange(exchange);
        // customer.updatePoint(dto.quantity(),gift.getPoint());
        // customerRepo.save(customer);
        return exchange;
    }
}
