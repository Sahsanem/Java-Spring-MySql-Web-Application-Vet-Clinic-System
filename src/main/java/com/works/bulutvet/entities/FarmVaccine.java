package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FarmVaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "farm_vaccine_id", nullable = false)
    private Integer farm_vaccine_id;

    private String farm_vaccine_name;
    private String farm_vaccine_unit;
    private int category_group_id;
    private int vendor_id;
    private String farm_vaccine_type;
    private int farm_vaccine_barcode;
    private int farm_vaccine_code;
    private int farm_vaccine_kdv;
    private int farm_vaccine_buying;
    private int farm_vaccine_sales;
    private int farm_vaccine_stock;
    private boolean farm_vaccine_status;
    private boolean farm_vaccine_sales_kdv;
    private boolean farm_vaccine_buying_kdv;
    private boolean farm_vaccine_amount_fixed;
    private String farm_vaccine_tip;

}
