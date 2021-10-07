package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PetVaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_vaccine_id", nullable = false)
    private Integer pet_vaccine_id;

    private String pet_vaccine_name;
    private String pet_vaccine_unit;
    private int category_group_cg_id;
    private int vendor_vid;
    private String pet_vaccine_type;
    private int pet_vaccine_barcode;
    private int pet_vaccine_code;
    private int pet_vaccine_kdv;
    private int pet_vaccine_buying;
    private int pet_vaccine_sales;
    private int pet_vaccine_stock;
    private boolean pet_vaccine_status;
    private boolean pet_vaccine_sales_kdv;
    private boolean pet_vaccine_buying_kdv;
    private boolean pet_vaccine_amount_fixed;
    private String pet_vaccine_tip;
    private int pet_vaccine_number;
}
