package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.Stock;
import com.works.bulutvet.entities.StockJoinDepo;
import com.works.bulutvet.entities.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {

    @Query(value = "select st.SID,st.DEPO,st.AMOUNT,st.PRODUCT, d.DEPO_NAME from STOCK as st INNER JOIN DEPO as d on st.DEPO = d.DEPO_ID WHERE d.DEPO_ID= ?1", nativeQuery = true)
    List<StockJoinDepo> stockJoinDepo(int depo_id);

    @Query(value = "select (SUM(st.amount) + SUM(f.number) + SUM(p.amount)) as totalStock from DEPO as d INNER JOIN STOCK as st on st.DEPO = d.DEPO_ID INNER JOIN PET_STOCK as p on p.depo = d.depo_id INNER JOIN FARM_STOCK as f on f.warehouse = d.depo_id", nativeQuery = true)
    List<Stocks> stocks();

}

