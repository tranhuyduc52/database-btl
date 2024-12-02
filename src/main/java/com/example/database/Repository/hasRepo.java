package com.example.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.Embedded.has_embed;
import com.example.database.Relationship.has;

public interface hasRepo extends JpaRepository<has,has_embed>{
    
}
