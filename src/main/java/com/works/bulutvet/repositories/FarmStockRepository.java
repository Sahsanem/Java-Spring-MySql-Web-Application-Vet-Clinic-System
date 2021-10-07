package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.FarmStock;
import com.works.bulutvet.entities.FarmStockJoinDepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmStockRepository extends JpaRepository<FarmStock,Integer> {

    @Query(value = "select  st.FSID,st.WAREHOUSE,st.NUMBER,st.FARM_VAC, d.DEPO_NAME from FARM_STOCK as st INNER JOIN DEPO as d on st.WAREHOUSE = d.DEPO_ID WHERE d.DEPO_ID= ?1", nativeQuery = true)
    List<FarmStockJoinDepo> farmStockJoinDepo(int depo_id);
}
