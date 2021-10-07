package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.Box;
import com.works.bulutvet.entities.ProductJoinBox;
import com.works.bulutvet.entities.ProductJoinVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoxRepository extends JpaRepository<Box,Integer> {

    @Query(value = "  select pro.PRODUCT_ID, pro.PRODUCT_NAME as product_name ,b.SALES_PRODUCT_AMOUNT , ((pro.PRODUCT_SALES * b.SALES_PRODUCT_AMOUNT )-((pro.PRODUCT_SALES* b.SALES_PRODUCT_AMOUNT)*pro.PRODUCT_KDV/100)) as total from PRODUCT as pro INNER JOIN BOX as b" +
            "    on pro.PRODUCT_ID = b.RETAIL_PRO_SEARCH where pro.PRODUCT_ID= ?1 AND  b.SALES_PRODUCT_AMOUNT=?2 ",nativeQuery = true)
    List<ProductJoinBox> productJoinBox(int box_id, int sales_product_amount);




}
