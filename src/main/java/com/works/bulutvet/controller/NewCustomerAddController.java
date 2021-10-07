package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Animal;
import com.works.bulutvet.entities.Customer;
import com.works.bulutvet.repositories.AnimalRepository;
import com.works.bulutvet.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/newCustomerAdd")
public class NewCustomerAddController {
    final CustomerRepository cRepo;
    final AnimalRepository animalRepository;

    public NewCustomerAddController(CustomerRepository cRepo, AnimalRepository animalRepository) {
        this.cRepo = cRepo;
        this.animalRepository = animalRepository;
    }

    @GetMapping("")
    public String newCustomerAdd(){

        return "newCustomerAdd";
    }

    @ResponseBody
    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer){
        Customer c=cRepo.save(customer);
        return c;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Customer> list() {
        return cRepo.findAll();
    }

    @ResponseBody
    @PostMapping("/animal")
    public Animal add(@RequestBody Animal animal) {
        //jpa-----
        Animal a = animalRepository.save(animal);
        return a;
    }

}




