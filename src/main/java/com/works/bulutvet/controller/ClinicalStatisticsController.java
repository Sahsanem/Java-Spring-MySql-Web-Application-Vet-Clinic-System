package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Animals;
import com.works.bulutvet.entities.BuyingJoinCustomer;
import com.works.bulutvet.entities.CustomerPaySale;
import com.works.bulutvet.entities.ScheduleCalendars;
import com.works.bulutvet.repositories.AnimalRepository;
import com.works.bulutvet.repositories.BuyingRepository;
import com.works.bulutvet.repositories.CustomerPaySaleRepository;
import com.works.bulutvet.repositories.ScheduleCalendarRepository;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/clinicalStatistics")
public class ClinicalStatisticsController {

    final UtilService uservice;
    final CustomerPaySaleRepository cpRepo;
    final BuyingRepository bRepo;
    final AnimalRepository aRepo;
    final ScheduleCalendarRepository scRepo;

    public ClinicalStatisticsController(UtilService uservice, CustomerPaySaleRepository cpRepo, BuyingRepository bRepo, AnimalRepository aRepo, ScheduleCalendarRepository scRepo) {
        this.uservice = uservice;
        this.cpRepo = cpRepo;
        this.bRepo = bRepo;
        this.aRepo = aRepo;
        this.scRepo = scRepo;
    }

    @GetMapping("")
    public String clinicalStatistics(Model model){
        model.addAttribute("countlab",uservice.countlab());

        return "clinicalStatistics";
    }


    @ResponseBody
    @GetMapping("/clinicList")
    public List<CustomerPaySale> clinicList(){

        return cpRepo.findAll();
    }


    @ResponseBody
    @GetMapping("/listProcess")
    public List<BuyingJoinCustomer> listProcess(Model model){

        List<BuyingJoinCustomer> listProcess = bRepo.listprocess();
        model.addAttribute("listProcess",listProcess);
        return listProcess;

    }

    @ResponseBody
    @GetMapping("/totalAnimal")
    public List<Animals> animals(){

        return aRepo.totalAnimal();

    }
    @ResponseBody
    @GetMapping("/totalSchedule")
    public List<ScheduleCalendars> schedules(){

        return scRepo.schedules();

    }



}