package com.example.database.service.interf;

import com.example.database.dto.request.ShiftRequest;

public interface IShiftService {
    void createShift(ShiftRequest dto);
    void delShift(int id);
}
