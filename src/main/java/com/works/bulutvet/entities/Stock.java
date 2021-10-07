package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Integer sid;
    private int depo;
    private int amount;
    private int product;




}

