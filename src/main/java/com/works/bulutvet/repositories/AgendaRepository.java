package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda,Integer> {
}
