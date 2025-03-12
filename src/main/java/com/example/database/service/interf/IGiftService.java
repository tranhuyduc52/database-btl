package com.example.database.service.interf;

import java.util.List;

import com.example.database.dto.request.GiftRequest;
import com.example.database.dto.respone.GiftResponse;

public interface IGiftService {
    void addGift(GiftRequest dto);
    void hideGift(int id);
    void delGift(int id);
    List<GiftResponse> findAllGift();
    void updateGift(GiftResponse dto);
}
