package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Customer;
import com.works.bulutvet.repositories.CustomerRepository;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/labCustomerDetail")
public class LabCustomerDetailController {
    final CustomerRepository cRepo;
    final UtilService utilService;
    public LabCustomerDetailController(CustomerRepository cRepo, UtilService utilService) {
        this.cRepo = cRepo;
        this.utilService = utilService;
    }

    @GetMapping("")
    public String labCustomerDetail(){


        return "labCustomerDetail";
    }
  /*  @GetMapping("/{stcid}")
    public String labCusDetail(Model model, @PathVariable String stcid){
        List<String> ls=new ArrayList<>();


            int cid=Integer.parseInt(stcid);
            model.addAttribute("customer",utilService.customerDetail(stcid));
            System.out.println(utilService.customerDetail(stcid));
            model.addAttribute("ls",utilService.custDetail(stcid));
            System.out.println(utilService.custDetail(stcid));


        return "redirect:/labCustomerDetail";

    }*/
    // cRepo.findById(cid);
    //   userUpdate=cRepo.findById(cid).get();
    // ls.add(utilService.customerDetail(stcid));

    @GetMapping("/{stcid}")
    public String labCusDetail(Model model, @PathVariable String stcid){
        // List<String> ls=new ArrayList<>();


        int cid=Integer.parseInt(stcid);
        model.addAttribute("customer",utilService.customerDetail(stcid));
        System.out.println(utilService.customerDetail(stcid));


        //model.addAttribute("ls",utilService.custDetail(stcid));
        //System.out.println(utilService.custDetail(stcid));


        return "redirect:/labCustomerDetail";

    }
}
