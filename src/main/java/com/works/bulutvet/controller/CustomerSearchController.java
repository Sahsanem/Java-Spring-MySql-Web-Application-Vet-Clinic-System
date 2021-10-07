package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Customer;
import com.works.bulutvet.repositories.CustomerRepository;
import com.works.bulutvet.services.CustomerService;
import com.works.bulutvet.services.UtilService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/customerSearch")
@Controller
public class CustomerSearchController {
    final CustomerRepository cRepo;
    final UtilService uService;
    final CustomerService cService;
    public CustomerSearchController(CustomerRepository cRepo, UtilService uService, CustomerService cService) {
        this.cRepo = cRepo;
        this.uService = uService;
        this.cService = cService;
    }

    @GetMapping("")
    public List<Customer> customerSearch(Model model,@Param("name") String name){
        // model.addAttribute("clist",uService.customerList());
        // List<Customer> clist=cRepo.findByC_name(c_name);
        List<Customer> listCustomers = cService.listAll(name);
        model.addAttribute("listCustomers", listCustomers);
        model.addAttribute("c_name", name);

        return listCustomers ;
    }


}