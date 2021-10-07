package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.NewCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<NewCase,Integer> {
}

