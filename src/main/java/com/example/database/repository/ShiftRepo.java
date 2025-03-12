package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.Shift;

public interface ShiftRepo extends JpaRepository<Shift,Integer>{
     
}
