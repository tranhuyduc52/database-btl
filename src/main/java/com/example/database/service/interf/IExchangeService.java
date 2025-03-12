package com.example.database.service.interf;

import java.util.List;

import com.example.database.dto.request.ExchangeRequest;
import com.example.database.dto.respone.ExchangeResponse;

public interface IExchangeService {
    void createExchange(ExchangeRequest exchangeDto,String phoneNumber);
    List<ExchangeResponse> getAllExchange();
}
