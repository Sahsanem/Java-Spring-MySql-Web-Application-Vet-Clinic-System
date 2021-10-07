package com.works.bulutvet.controller;

import com.works.bulutvet.entities.*;
import com.works.bulutvet.repositories.BuyingRepository;
import com.works.bulutvet.repositories.ProductRepository;
import com.works.bulutvet.repositories.VendorRepository;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/buying")
public class BuyingController {

    final ProductRepository pRepo;
    final VendorRepository vRepo;
    final BuyingRepository bRepo;
    final UtilService uService;

    public BuyingController(ProductRepository pRepo, VendorRepository vRepo, BuyingRepository bRepo, UtilService uService) {
        this.pRepo = pRepo;
        this.vRepo = vRepo;
        this.bRepo = bRepo;
        this.uService = uService;
    }

    @GetMapping("")
    public String buying(Model model){
        model.addAttribute("ls",uService.categoryGroupList());
        model.addAttribute("ls1",uService.vendorList());


        return "buying";
    }

    @ResponseBody
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){

        Product p = pRepo.save(product);

        return p;

    }

    @ResponseBody
    @PostMapping("/addVendor")
    public Vendor addVendor(@RequestBody Vendor vendor){

        Vendor v = vRepo.save(vendor);

        return v;

    }

    @ResponseBody
    @GetMapping("/listVendor")
    public List<Vendor> list(){
        return vRepo.findAll();
    }

    @ResponseBody
    @GetMapping("/listProduct")
    public List<Product> listProduct(){

        return pRepo.findAll();

    }

    @ResponseBody
    @GetMapping("/productVendor/{stVid}")
    public List<ProductJoinVendor> productJoinVendors(Model model, @PathVariable String stVid){

        int vid = Integer.parseInt(stVid);
        List<ProductJoinVendor> productJoinVendors = pRepo.productJoinVendor(vid);
        model.addAttribute("ls3",productJoinVendors);

        return productJoinVendors;

    }

    @ResponseBody
    @GetMapping("/productTotal/{stPid}")
    public List<VendorProductStock> productTotal(Model model, @PathVariable String stPid){
        int pid = Integer.parseInt(stPid);
        List<VendorProductStock> productTotal = pRepo.vendorJoinProductJoinStock(pid);
        model.addAttribute("total",productTotal);
        return productTotal;

    }

    @ResponseBody
    @PostMapping("/addTotal")
    public Buying add(@RequestBody Buying buying) {
        //jpa-----
        Buying b = bRepo.save(buying);
        return b;
    }

    @ResponseBody
    @GetMapping("/listBuying")
    public List<Buying> listBuying() {
        return bRepo.findAll();
    }


}
