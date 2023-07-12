package com.cydeo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Customers")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    // in OneToMany relationship,ownership belongs to Many side
    private List<Payment> paymentList;

    public Customer(String address, String email, String name, String surName, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
    }
}
