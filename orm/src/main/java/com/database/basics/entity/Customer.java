package com.database.basics.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String email;


    @OneToMany
    private List<Order> list;



}
