package com.example.database.myenum;

import lombok.AllArgsConstructor;



@AllArgsConstructor
public enum GenderEnum {
    female('F'),male('M');
    private final char ten;
    public char getTen(){
        return ten;
    }
}
