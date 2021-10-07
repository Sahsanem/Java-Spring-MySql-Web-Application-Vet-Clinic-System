package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.CustomerPaySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerPaySaleRepository extends JpaRepository<CustomerPaySale,Integer> {

    @Query(value = "select SUM(SALE_BOXTOTAL) as s2 from CUSTOMER_PAY_SALE ",nativeQuery = true)
    int customerSale();

    @Query(value = "select COUNT(cp_id)from CUSTOMER_PAY_SALE  ",nativeQuery = true)
    int countSale();


    @Query(value = " select * from CUSTOMER_PAY_SALE where CUSTOMER_PROCESS = ?1 ",nativeQuery = true)
    List<CustomerPaySale> process(int pr);



}
