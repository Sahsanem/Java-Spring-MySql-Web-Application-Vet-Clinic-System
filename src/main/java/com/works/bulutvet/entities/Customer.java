package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer cid;

    private String c_name;
    private String c_surname;
    private String c_phone;
    private String c_mobile_phone;
    private String c_email;
    private String tax_administration;
    private String c_note;
    private String tc_no;
    private String il;
    private String ilce;
    private String address;
    private String c_code;
    private String c_no;


}
