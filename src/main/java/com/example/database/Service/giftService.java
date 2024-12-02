package com.example.database.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Gift.giftDto;
import com.example.database.Gift.giftMapper;
import com.example.database.Gift.giftResponseDto;
import com.example.database.Repository.giftRepo;

@Service
public class giftService {
    @Autowired
    private giftRepo repo;
    @Autowired
    private giftMapper giftMapper;
    public void addGift(giftDto dto){
        repo.save(giftMapper.tGift(dto));
    }
    public void hideGift(int id){
        repo.hideGift(id);
    }
    public void delGift(int id){
        repo.deleteById(id);
    }
    public List<giftResponseDto> findAllGift(){
        return repo.findByState(true).stream()
        .map(giftMapper::tGiftResponseDto)
        .collect(Collectors.toList());
    }
    public void updateGift(giftResponseDto dto){
        repo.updateGift(dto.id(),dto.name(),dto.point());
    }
}
