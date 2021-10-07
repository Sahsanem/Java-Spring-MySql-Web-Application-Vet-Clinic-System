package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CategoryGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cg_id", nullable = false)
    private Integer cg_id;
    private String cg_name;
    private boolean cg_status;
}