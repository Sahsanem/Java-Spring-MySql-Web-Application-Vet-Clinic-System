package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Depo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depo_id", nullable = false)
    private Integer depo_id;
    private String depo_name;
    private boolean depo_status;
}
