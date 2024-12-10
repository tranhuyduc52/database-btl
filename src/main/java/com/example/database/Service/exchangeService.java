package com.example.database.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Relationship.exchangeDto;
import com.example.database.Relationship.exchangeMapper;
import com.example.database.Relationship.exchangeResponseDto;
import com.example.database.Repository.exchangeRepo;

@Service
public class exchangeService {
    @Autowired
    private exchangeRepo repo;
    @Autowired
    private exchangeMapper exchangeMapper;
    public void createExchange(exchangeDto exchangeDto,int phoneNumber){
        repo.save(exchangeMapper.tExchange(exchangeDto, phoneNumber));
    }
    public List<exchangeResponseDto> getAllExchange(){
        return repo.findAll().stream()
        .map(exchangeMapper::tExchangeResponseDto)
        .collect(Collectors.toList());
    }
}
