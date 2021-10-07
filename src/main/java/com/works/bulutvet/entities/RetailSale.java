package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class RetailSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid", nullable = false)
    private Integer rid;

    private int saletotal;
    private String product_name;
    private int sale_process;
    private Date sale_date;


}
