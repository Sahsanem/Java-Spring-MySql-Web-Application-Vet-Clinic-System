package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.PetStock;
import com.works.bulutvet.entities.PetStockJoinDepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetStockRepository extends JpaRepository<PetStock,Integer> {

    @Query(value = "select  st.PSID,st.DEPO,st.AMOUNT,st.PET_VAC, d.DEPO_NAME from PET_STOCK as st INNER JOIN DEPO as d on st.DEPO = d.DEPO_ID WHERE d.DEPO_ID= ?1", nativeQuery = true)
    List<PetStockJoinDepo> petStockJoinDepo(int depo_id);

}
