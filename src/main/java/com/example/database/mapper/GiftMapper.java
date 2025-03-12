package com.example.database.mapper;

import org.springframework.stereotype.Service;

import com.example.database.dto.request.GiftRequest;
import com.example.database.dto.respone.GiftResponse;
import com.example.database.model.Gift;

@Service
public class GiftMapper {
    public GiftResponse tGiftResponseDto(Gift gift){
        return new GiftResponse(gift.getId(),gift.getName(),gift.getPoint());
    }
    public Gift tGift(GiftRequest dto){
        var gift = new Gift();
        gift.setName(dto.name());
        gift.setPoint(dto.point());
        gift.setAvailable(true);
        return gift;
    }
}
