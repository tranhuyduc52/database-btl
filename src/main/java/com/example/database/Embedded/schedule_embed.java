package com.example.database.Embedded;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class schedule_embed implements Serializable{
    private int shiftId;
    private int employeeId;
    private Date date;
}
