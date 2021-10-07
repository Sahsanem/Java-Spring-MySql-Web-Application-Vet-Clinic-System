package com.works.bulutvet.controller;

import com.works.bulutvet.entities.User;
import com.works.bulutvet.entities.Vendor;
import com.works.bulutvet.repositories.VendorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vendor")
public class VendorController {

    final VendorRepository vRepo;

    public VendorController(VendorRepository vRepo) {
        this.vRepo = vRepo;
    }

    @GetMapping("")
    public String vendor(Model model){

        return "vendor";
    }


    @ResponseBody
    @PostMapping("/add")
    public Vendor add(@RequestBody Vendor vendor){
        //jpa-----
        Vendor v = vRepo.save(vendor);
        return v;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Vendor> list(){
        return vRepo.findAll();
    }



    @ResponseBody
    @DeleteMapping(value = "/delete/{stVid}")
    public String delete(@PathVariable String stVid) {
        String status = "0";
        try{
            int vid = Integer.parseInt(stVid);
            vRepo.deleteById(vid);
            status= "1";

        }catch (Exception e){
            System.err.println("Silme sırasında hata oluştu");
        }

        return status;

    }
}

