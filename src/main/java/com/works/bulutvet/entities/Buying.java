package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Buying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid", nullable = false)
    private Integer bid;

    private String name;
    private int productName;
    private int total;
    private String billNumber;
    private int process;
    private String buyingNote;
    private Date buying_date;

}
