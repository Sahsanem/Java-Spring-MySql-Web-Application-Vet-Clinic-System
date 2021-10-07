package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Agenda;
import com.works.bulutvet.entities.Vendor;
import com.works.bulutvet.repositories.AgendaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
    final AgendaRepository aRepo;

    public AgendaController(AgendaRepository aRepo) {
        this.aRepo = aRepo;
    }

    @GetMapping("")
    public String agenda() {
        return "agenda";
    }


    @ResponseBody
    @PostMapping("/add")
    public Agenda add(@RequestBody Agenda agenda) {
        //jpa-----
        Agenda a = aRepo.save(agenda);
        return a;
    }


    @ResponseBody
    @GetMapping("/list")
    public List<Agenda> list() {
        return aRepo.findAll();
    }


    @ResponseBody
    @DeleteMapping(value = "/delete/{stAid}")
    public String delete(@PathVariable String stAid) {
        String status = "0";
        try {
            int aid = Integer.parseInt(stAid);
            aRepo.deleteById(aid);
            status = "1";

        } catch (Exception e) {
            System.err.println("Silme sırasında hata oluştu");
        }

        return status;

    }
}