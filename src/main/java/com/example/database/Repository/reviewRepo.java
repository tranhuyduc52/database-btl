package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.Review;
import com.example.database.model.ReviewEmbed;

public interface ReviewRepo extends JpaRepository<Review,ReviewEmbed>{
    
}
