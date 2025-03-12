package com.example.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ShiftRequest;
import com.example.database.mapper.ShiftMapper;
import com.example.database.repository.ShiftRepo;
import com.example.database.service.interf.IShiftService;


@Service
public class ShiftService implements IShiftService{
    @Autowired
    private ShiftMapper shiftMapper;
    @Autowired
    private ShiftRepo repo;
    public void createShift(ShiftRequest dto){
        repo.save(shiftMapper.tShift(dto));
    }
    public void delShift(int id){
        repo.deleteById(id);
    }
}
