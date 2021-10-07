package com.works.bulutvet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping("")
    public String content(){
        return "content";
    }
}
