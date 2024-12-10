package com.example.database.Gift;

import org.springframework.stereotype.Service;

@Service
public class giftMapper {
    public giftResponseDto tGiftResponseDto(gift gift){
        return new giftResponseDto(gift.getId(),gift.getName(),gift.getPoint());
    }
    public gift tGift(giftDto dto){
        var gift = new gift();
        gift.setName(dto.name());
        gift.setPoint(dto.point());
        gift.setAvailable(true);
        return gift;
    }
}
