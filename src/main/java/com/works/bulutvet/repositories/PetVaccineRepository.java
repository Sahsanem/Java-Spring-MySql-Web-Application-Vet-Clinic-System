package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.PetVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PetVaccineRepository extends JpaRepository<PetVaccine,Integer> {

}
