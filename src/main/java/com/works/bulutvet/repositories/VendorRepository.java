package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Integer> {
}
