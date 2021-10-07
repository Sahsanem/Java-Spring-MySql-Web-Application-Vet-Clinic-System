package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CustomerPaySale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cp_id", nullable = false)
    private Integer cp_id;

    private int saleBoxtotal;
    private String c_name;
    private int customer_process;
    private int customerBillNumber;
    private Date box_cus_date;
}
