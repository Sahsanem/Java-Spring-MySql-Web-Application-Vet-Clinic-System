package com.works.bulutvet.controller;

import com.works.bulutvet.entities.CategoryGroup;
import com.works.bulutvet.entities.Depo;
import com.works.bulutvet.repositories.DepoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depo")
@Controller
public class DepoController {
    final DepoRepository dRepo;

    public DepoController(DepoRepository dRepo) {
        this.dRepo = dRepo;
    }

    @GetMapping("")
    public String depo(Model model){
        return "depo";
    }

    @ResponseBody
    @PostMapping("/add")
    public Depo addDepo(@RequestBody Depo depo){
        Depo d = dRepo.save (depo);
        return d;

    }

    @ResponseBody
    @GetMapping("/list")
    public List<Depo> listDepo(){

        return dRepo.findAll();

    }

    @ResponseBody
    @DeleteMapping(value = "/delete/{stDid}")
    public String delete(@PathVariable String stDid){
        String status = "0";
        System.out.println("stDid: " + stDid);
        try {
            int depo_id = Integer.parseInt(stDid);
            dRepo.deleteById(depo_id);
            status = "1";
        } catch (Exception e) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!" + e);
        }
        return status;
    }
}
