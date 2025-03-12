package com.example.database.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.GiftRequest;
import com.example.database.dto.respone.GiftResponse;
import com.example.database.mapper.GiftMapper;
import com.example.database.repository.GiftRepo;
import com.example.database.service.interf.IGiftService;


@Service
public class GiftService implements IGiftService{
    @Autowired
    private GiftRepo repo;
    @Autowired
    private GiftMapper giftMapper;
    public void addGift(GiftRequest dto){
        repo.save(giftMapper.tGift(dto));
    }
    public void hideGift(int id){
        repo.hideGift(id);
    }
    public void delGift(int id){
        repo.deleteById(id);
    }
    public List<GiftResponse> findAllGift(){
        return repo.findByIsAvailable(true).stream()
        .map(giftMapper::tGiftResponseDto)
        .collect(Collectors.toList());
    }
    public void updateGift(GiftResponse dto){
        repo.updateGift(dto.id(),dto.name(),dto.point());
    }
}
