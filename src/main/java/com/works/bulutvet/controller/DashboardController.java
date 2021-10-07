package com.works.bulutvet.controller;

import com.works.bulutvet.entities.*;
import com.works.bulutvet.repositories.AnimalRepository;
import com.works.bulutvet.repositories.CustomerRepository;
import com.works.bulutvet.repositories.ScheduleCalendarRepository;
import com.works.bulutvet.repositories.StockRepository;
import com.works.bulutvet.services.UtilService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private static final Logger log=Logger.getLogger(DashboardController.class);
    final UtilService uService;
    final ScheduleCalendarRepository sRepo;
    final StockRepository stRepo;

    final CustomerRepository cRepo;


    public DashboardController(UtilService uService, ScheduleCalendarRepository sRepo, StockRepository stRepo,  CustomerRepository cRepo) {
        this.uService = uService;
        this.sRepo = sRepo;
        this.stRepo = stRepo;

        this.cRepo = cRepo;

    }

    @GetMapping("")
    public String dashboard(Model model) {
        model.addAttribute("calendars",uService.scheduleCalendars());
        model.addAttribute("sum",uService.total());
        model.addAttribute("sum2",uService.countSale());
        log.debug("debug message");
        return "dashboard";
    }
    @ResponseBody
    @GetMapping("/randevulist")
    public List<ScheduleCalendar> listRandevu(){

        return sRepo.findAll();

    }
    @ResponseBody
    @GetMapping("/total")
    public List<Stocks> stocks(){

        return stRepo.stocks();

    }

    @ResponseBody
    @GetMapping("/totalCustomer")
    public List<Customers> customers(){

        return cRepo.totalCustomer();

    }








}