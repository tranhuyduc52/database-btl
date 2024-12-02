package com.example.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.Embedded.schedule_embed;
import com.example.database.Relationship.schedule;

public interface scheduleRepo extends JpaRepository<schedule,schedule_embed>{
    
}
