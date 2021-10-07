package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class NewCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id", nullable = false)
    private Integer case_id;
    private String case_type;
    private String case_name;
    private boolean case_status;
}