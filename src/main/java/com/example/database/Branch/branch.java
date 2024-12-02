package com.example.database.Branch;

import java.util.List;

import com.example.database.Employee.employee;
import com.example.database.Order._order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class branch {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int phoneNumber;
    private String location;
    @OneToMany(mappedBy = "branch")
    private List<employee> employees;
    @OneToMany(mappedBy = "branch")
    private List<_order> _orders;
}
