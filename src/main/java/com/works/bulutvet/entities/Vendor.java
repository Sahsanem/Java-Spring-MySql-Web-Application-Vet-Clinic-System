package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vid", nullable = false)
    private Integer vid;
    private String vendor_name;
    private String vendor_email;
    private String vendor_phone;
}
