package com.example.database.myenum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PositionEnum {
    manager("MANAGER"), cashier("CASHIER"), barista("BARISTA"), waiter("WAITER");
    private final String position;
    public String getPosition(){
        return position;
    }
}