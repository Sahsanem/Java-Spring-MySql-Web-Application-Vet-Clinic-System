package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.AnimalLaboratuvarCustomer;
import com.works.bulutvet.entities.Laboratuvar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LaboratuvarRepository extends JpaRepository<Laboratuvar,Integer> {

    @Query(value = "select l.LID, a.P_NAME,a.AID,c.C_NAME,c.C_SURNAME,l.DIAGNOSIS,l.LAB_TYPE from ANIMAL as a INNER JOIN LABORATUVAR AS l ON l.animal_name=a.aid INNER JOIN CUSTOMER as c ON c.C_NO=a.CUS_NO",nativeQuery = true)
    List<AnimalLaboratuvarCustomer> animalLaboratuvarCustomer();

    @Query(value = "select count(lid) from LABORATUVAR",nativeQuery = true)
    int countlab();




}
