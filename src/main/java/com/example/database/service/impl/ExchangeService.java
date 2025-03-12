package com.example.database.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ExchangeRequest;
import com.example.database.dto.respone.ExchangeResponse;
import com.example.database.mapper.ExchangeMapper;
import com.example.database.repository.ExchangeRepo;
import com.example.database.service.interf.IExchangeService;


@Service
public class ExchangeService implements IExchangeService{
    @Autowired
    private ExchangeRepo repo;
    @Autowired
    private ExchangeMapper exchangeMapper;
    public void createExchange(ExchangeRequest exchangeDto,String phoneNumber){
        repo.save(exchangeMapper.tExchange(exchangeDto, phoneNumber));
    }
    public List<ExchangeResponse> getAllExchange(){
        return repo.findAll().stream()
        .map(exchangeMapper::tExchangeResponseDto)
        .collect(Collectors.toList());
    }
}
