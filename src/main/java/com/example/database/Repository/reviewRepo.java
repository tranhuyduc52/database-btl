package com.example.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.Embedded.review_embed;
import com.example.database.Relationship.review;

public interface reviewRepo extends JpaRepository<review,review_embed>{
    
}
