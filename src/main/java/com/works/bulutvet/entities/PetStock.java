package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PetStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "psid", nullable = false)
    private Integer psid;
    private int depo;
    private int pet_vac;
    private int amount;
}
