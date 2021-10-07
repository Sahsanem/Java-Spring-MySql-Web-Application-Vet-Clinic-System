package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Buying;
import com.works.bulutvet.entities.CustomerPaySale;
import com.works.bulutvet.entities.ProductBoxCustomer;
import com.works.bulutvet.repositories.BuyingRepository;
import com.works.bulutvet.repositories.CustomerPaySaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/payAction")
public class PayActionController {

    final BuyingRepository bRepo;
    final CustomerPaySaleRepository cpRepo;

    public PayActionController(BuyingRepository bRepo, CustomerPaySaleRepository cpRepo) {
        this.bRepo = bRepo;
        this.cpRepo = cpRepo;
    }

    @GetMapping("")
    public String payaction(){
        return "payAction";
    }


    @ResponseBody
    @GetMapping("/payInlist")
    public List<Buying> listBuying() {
        return bRepo.findAll();
    }

    @ResponseBody
    @GetMapping("/payOutlist")
    public List<CustomerPaySale> listSale() {
        return cpRepo.findAll();
    }


    @ResponseBody
    @GetMapping("/salectProcess/{stPr}")
    public List<CustomerPaySale> selectProcess(Model model, @PathVariable String stPr){
        int pr = Integer.parseInt(stPr);
        List<CustomerPaySale> selectprocess = cpRepo.process(pr);
        model.addAttribute("selectProcess",selectprocess);
        return selectprocess;

    }






}

