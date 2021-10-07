package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BoxCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bc_id", nullable = false)
    private Integer bc_id;

    private int productName;
    private int customerName;
    private int box_customer_amount;
    private String customer_note;

}
