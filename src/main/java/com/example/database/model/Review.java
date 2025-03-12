package com.example.database.model;


import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @EmbeddedId
    private ReviewEmbed id = new ReviewEmbed();
    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_ID")
    private Customer customer;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_ID")
    private Product product;
    private int score;
    private Date date;
    private String comment;
}
