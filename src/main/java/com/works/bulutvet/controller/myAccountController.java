package com.works.bulutvet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myAccount")
public class myAccountController {


    @GetMapping("")
    public String myAccount(){

        return "myAccount";
    }
}
