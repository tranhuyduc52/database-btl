package com.example.database.Relationship;


import java.sql.Date;

import com.example.database.Customer.customer;
import com.example.database.Embedded.exchange_embed;
import com.example.database.Gift.gift;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class exchange {
    @EmbeddedId
    private exchange_embed id = new exchange_embed();
    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_ID")
    private customer customer;
    @ManyToOne
    @MapsId("giftId")
    @JoinColumn(name = "gift_ID")
    private gift gift;
    private int quantity;
    private Date date;
}
