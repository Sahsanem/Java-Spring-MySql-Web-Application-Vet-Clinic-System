package com.works.bulutvet.controller;

import com.works.bulutvet.entities.NewCase;
import com.works.bulutvet.repositories.CaseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewCaseDescriptionController {
    final CaseRepository cRepo;

    public NewCaseDescriptionController(CaseRepository cRepo) {
        this.cRepo = cRepo;
    }

    @GetMapping("/newCaseDescription")
    public String newCaseDescription(Model model){
        return "newCaseDescription";
    }



    @ResponseBody
    @PostMapping("/newCaseDescription/add")
    public NewCase addCase(@RequestBody NewCase newCase){
        NewCase c = cRepo.save(newCase);
        return c;

    }

    @ResponseBody
    @GetMapping("/newCaseDescription/list")
    public List<NewCase> listCase(){

        return cRepo.findAll();

    }

    @ResponseBody
    @DeleteMapping("/newCaseDescription/delete/{stcid}")
    public String delete(@PathVariable String stcid){
        String status = "0";
        System.out.println("stCgid: " + stcid);
        try {
            int case_id = Integer.parseInt(stcid);
            cRepo.deleteById(case_id);
            status = "1";
        } catch (Exception e) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!" + e);
        }
        return status;
    }
}
