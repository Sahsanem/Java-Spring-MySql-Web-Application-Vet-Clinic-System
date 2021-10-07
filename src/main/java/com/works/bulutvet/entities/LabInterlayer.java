package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class LabInterlayer {


    private Integer lab_type;
    private Integer animalName;
    private String diagnosis;
    private Integer cus_no;


}
