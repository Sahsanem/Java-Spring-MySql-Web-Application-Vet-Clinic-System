package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.BoxCustomer;
import com.works.bulutvet.entities.ProductBoxCustomer;
import com.works.bulutvet.entities.ProductJoinBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoxCustomerRepository extends JpaRepository<BoxCustomer,Integer> {

    @Query(value = " select c.C_NAME, ((pro.PRODUCT_SALES * bc.BOX_CUSTOMER_AMOUNT )-((pro.PRODUCT_SALES* bc.BOX_CUSTOMER_AMOUNT)*pro.PRODUCT_KDV/100)) AS TOTAL from PRODUCT as pro INNER JOIN BOX_CUSTOMER as bc on pro.PRODUCT_ID = bc.PRODUCT_NAME INNER JOIN CUSTOMER AS c on c.CID = bc.CUSTOMER_NAME where pro.PRODUCT_ID = ?1 and bc.BOX_CUSTOMER_AMOUNT = ?2 AND c.CID = ?3",nativeQuery = true)
    List<ProductBoxCustomer> productJoinBoxCustomer(int pid, int box_customer_amount, int cid);


}
