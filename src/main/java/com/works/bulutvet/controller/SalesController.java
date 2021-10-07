package com.works.bulutvet.controller;

import com.works.bulutvet.entities.*;
import com.works.bulutvet.repositories.*;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {
    final ProductRepository pRepo;
    final UtilService uService;
    final AnimalRepository aRepo;
    final BoxRepository bRepo;
    final RetailSaleRepository rRepo;
    final BoxCustomerRepository bcRepo;
    final CustomerPaySaleRepository cpRepo;
    public SalesController(ProductRepository pRepo, UtilService uService, AnimalRepository aRepo, BoxRepository bRepo, RetailSaleRepository rRepo, BoxCustomerRepository bcRepo, CustomerPaySaleRepository cpRepo) {
        this.pRepo = pRepo;
        this.uService = uService;
        this.aRepo = aRepo;
        this.bRepo = bRepo;
        this.rRepo = rRepo;
        this.bcRepo = bcRepo;
        this.cpRepo = cpRepo;
    }

    @GetMapping("")
    public String sales(Model model){
        model.addAttribute("ls",uService.producstList());
        model.addAttribute("animalList",uService.animalList());
        model.addAttribute("customerList",uService.customerList());

        return "sales";
    }


    @ResponseBody
    @PostMapping("/boxAdd")
    public Box boxAdd(@RequestBody  Box box){
        Box b=bRepo.save(box);
        return b;
    }

    @ResponseBody
    @GetMapping("/saleTotal/{stVid}/{stAmount}")
    public List<ProductJoinBox> saleTotal(Model model, @PathVariable String stVid, @PathVariable String stAmount){
        int vid = Integer.parseInt(stVid);
        int amount = Integer.parseInt(stAmount);
        List<ProductJoinBox> saleTotal = bRepo.productJoinBox(vid,amount);
        model.addAttribute("saletotal",saleTotal);
        return saleTotal;

    }


    @ResponseBody
    @PostMapping("/retailAdd")
    public RetailSale retailAdd(@RequestBody  RetailSale retailSale){
        RetailSale r=rRepo.save(retailSale);
        return r;
    }


    @ResponseBody
    @PostMapping("/customerBoxAdd")
    public BoxCustomer boxCustomer(@RequestBody  BoxCustomer boxCustomer){
        BoxCustomer bc=bcRepo.save(boxCustomer);
        return bc;
    }


    @ResponseBody
    @GetMapping("/saleCustomerTotal/{stPid}/{stCid}/{stsaleAmount}")
    public List<ProductBoxCustomer> saleTotal(Model model, @PathVariable String stPid, @PathVariable String stsaleAmount,@PathVariable String stCid){
        int pid = Integer.parseInt(stPid);
        int sale_amount = Integer.parseInt(stsaleAmount);
        int cid = Integer.parseInt(stCid);
        List<ProductBoxCustomer> saleCustomerTotal = bcRepo.productJoinBoxCustomer(pid,sale_amount,cid);
        model.addAttribute("saleCustomertotal",saleCustomerTotal);
        return saleCustomerTotal;

    }


    @ResponseBody
    @PostMapping("/customerPayAdd")
    public CustomerPaySale customerPaySale(@RequestBody  CustomerPaySale customerPaySale){
        CustomerPaySale cp=cpRepo.save(customerPaySale);
        return cp;
    }

    @ResponseBody
    @GetMapping("/listcustomerPay")
    public List<CustomerPaySale> listcustomerPay() {
        return cpRepo.findAll();
    }













}
