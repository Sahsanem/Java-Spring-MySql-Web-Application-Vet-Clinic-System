package com.works.bulutvet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/labAnimalDetail")
public class LabAnimalDetailController {
    @GetMapping("")
    public String labAnimalDetail(){
        return "labAnimalDetail";
    }
}
