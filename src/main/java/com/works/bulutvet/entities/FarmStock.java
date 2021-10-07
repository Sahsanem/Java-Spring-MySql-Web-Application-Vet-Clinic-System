package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FarmStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fsid", nullable = false)
    private Integer fsid;
    private int farm_vac;
    private int warehouse;
    private int number;

}
