package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "box_id", nullable = false)
    private Integer box_id;

    private int retail_pro_search;
    private int sales_product_amount;
    private String sales_note;

}
