package com.works.bulutvet.services;

import com.works.bulutvet.entities.Customer;
import com.works.bulutvet.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    final CustomerRepository cRepo;

    public CustomerService(CustomerRepository cRepo) {
        this.cRepo = cRepo;
    }

    public List<Customer> listAll(String c_name) {
        if (c_name != null) {
            return cRepo.findByC_name(c_name);
        }
        return cRepo.findAll();
    }
}
