package com.example.database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.Gift.gift;

import jakarta.transaction.TransactionScoped;

public interface giftRepo extends JpaRepository<gift,Integer>{
    @Modifying
    @TransactionScoped
    @Query("update gift a set a.state=false where a.id=:id")
    void hideGift(@Param("id") int id);
    List<gift> findByState(boolean state);
    @Modifying
    @TransactionScoped
    @Query("update gift a set a.name=:name,a.point=:point where a.id=:id")
    void updateGift(@Param("id") int id,@Param("name") String name,@Param("point") int point);
}
