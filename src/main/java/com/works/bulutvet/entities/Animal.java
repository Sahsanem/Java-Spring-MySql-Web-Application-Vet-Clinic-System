package com.works.bulutvet.entities;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", nullable = false)
    private Integer aid;

    private String p_name;
    @Column(unique = true)
    private int cip_no;
    private int karne_no;
    private Date p_birth;
    private String p_type;
    private String p_race;
    private String pcolor;
    private int gender;
    private boolean spayed;
    private int cus_no;


}
