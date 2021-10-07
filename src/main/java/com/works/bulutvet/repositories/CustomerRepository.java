package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.Customer;
import com.works.bulutvet.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "from Customer as c where c.c_name like concat('%', ?1, '%')")
    List<Customer> findByC_name(String c_name);

    @Query(value = "select COUNT( CID) as totalCustomer from CUSTOMER",nativeQuery = true)
    List<Customers> totalCustomer();

}
