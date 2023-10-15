package com.database.basics.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@Entity
@ToString
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue
    private int id;

    private Date date;

    private int amount ;

    @ManyToOne
    @JoinColumn
    private Customer custumer;


}
