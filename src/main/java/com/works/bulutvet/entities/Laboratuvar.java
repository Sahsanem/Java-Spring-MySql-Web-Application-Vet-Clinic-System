package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Laboratuvar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid", nullable = false)
    private Integer lid;


    private int lab_type;
    private int animalName;
    private String diagnosis;
    private String imageName;
    private int cus_no;


}
