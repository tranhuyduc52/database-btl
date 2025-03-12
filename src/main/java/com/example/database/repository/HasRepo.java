package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.Has;
import com.example.database.model.HasEmbed;



public interface HasRepo extends JpaRepository<Has,HasEmbed>{
    
}
