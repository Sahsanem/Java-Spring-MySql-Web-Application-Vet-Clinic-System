package com.works.bulutvet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer product_id;
    private String product_name;
    private String product_unit;
    private int category_group_cg_id;
    private int vendor_vid;
    private String product_type;
    private int product_barcode;
    private int product_code;
    private int product_kdv;
    private int product_buying;
    private int product_sales;
    private int product_stock;
    private boolean product_status;
    private boolean product_sales_kdv;
    private boolean product_buying_kdv;
    private boolean product_amount_fixed;

}
