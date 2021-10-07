package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", nullable = false)
    private Integer aid;

    private String agenda_title;
    private String agenda_desc;
    private Date agenda_date;
    private Boolean activeChecked;
    private String agenda_hours;

}
