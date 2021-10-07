package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Product;
import com.works.bulutvet.entities.Stock;
import com.works.bulutvet.repositories.ProductRepository;
import com.works.bulutvet.entities.StockJoinDepo;
import com.works.bulutvet.repositories.StockRepository;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/productDescription")
@Controller
public class ProductDescriptionController {

    final ProductRepository pRepo;
    final UtilService uService;
    final StockRepository sRepo;

    public ProductDescriptionController(ProductRepository pRepo, UtilService uService, StockRepository sRepo) {
        this.pRepo = pRepo;
        this.uService = uService;
        this.sRepo = sRepo;
    }
    Stock stockUpdate = new Stock();
    @GetMapping("")
    public String productDescription(Model model){
        model.addAttribute("ls",uService.categoryGroupList());
        model.addAttribute("ls1",uService.vendorList());
        model.addAttribute("depos",uService.depoList());
        return "productDescription";
    }

    @ResponseBody
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){

        Product p = pRepo.save(product);

        return p;

    }

    @ResponseBody
    @GetMapping("/list")
    public List<Product> listProduct(){

        return pRepo.findAll();

    }

    @ResponseBody
    @DeleteMapping("/delete/{stPid}")
    public String delete(@PathVariable String stPid){
        String status = "0";
        System.out.println("stPid: " + stPid);
        try {
            int product_id = Integer.parseInt(stPid);
            pRepo.deleteById(product_id);
            status = "1";
        } catch (Exception e) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!" + e);
        }
        return status;
    }

    @ResponseBody
    @GetMapping("/{stPid}")
    public Optional<Product> productDetail(Model model,@PathVariable String stPid){

        int product_id = Integer.parseInt(stPid);
        Optional<Product> products = pRepo.findById(product_id);
        model.addAttribute("products",products);

        return products;

    }
    @ResponseBody
    @PostMapping("/addStock")
    public Stock addStock(@RequestBody Stock stock){
        try {
            if ( stockUpdate.getSid() != null && stockUpdate.getSid() > 0  ) {
                stock.setSid(stockUpdate.getSid());
            }
            sRepo.saveAndFlush(stock);
            stockUpdate = new Stock();
        }catch (Exception ex) {

            System.err.println("Bu mail adresi daha önceden kayıt edilmiş!");
        }
        return stockUpdate;

    }

    @ResponseBody
    @GetMapping("/stockDepo/{stDid}")
    public List<StockJoinDepo> stockJoinDepos(Model model, @PathVariable String stDid){

        int depo_id = Integer.parseInt(stDid);
        List<StockJoinDepo> stockJoinDepos = sRepo.stockJoinDepo(depo_id);
        model.addAttribute("ls3",stockJoinDepos);

        return stockJoinDepos;

    }


    @GetMapping("/stockUpdate/{stSid}")
    public String stockUpdate(@PathVariable String stSid){
        try {
            int sid = Integer.parseInt(stSid);
            stockUpdate = sRepo.findById(sid).get();
        }catch (Exception ex) {
            System.err.println( "Update işlemi sırasında bir hata oluştu!");
        }
        return "redirect:/productDescription";
    }

    @ResponseBody
    @DeleteMapping("/stockDelete/{stSid}")
    public String stockDelete(@PathVariable String stSid){
        String status = "0";
        try {
            int sid = Integer.parseInt(stSid);
            sRepo.deleteById(sid);
            stockUpdate = new Stock();
            status = "1";
        }catch (Exception ex) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!");
        }
        return status;

    }



}

