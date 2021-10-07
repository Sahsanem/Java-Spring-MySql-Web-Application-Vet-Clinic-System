package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.Buyings;
import com.works.bulutvet.entities.RetailSale;
import com.works.bulutvet.entities.RetailSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RetailSaleRepository extends JpaRepository<RetailSale,Integer> {

    @Query(value = "select SUM(saletotal) as s1 from RETAIL_SALE ",nativeQuery = true)
    int retailSale();

    @Query(value = "select  COUNT(rid) from RETAIL_SALE ",nativeQuery = true)
    int countSale();
}
