package com.example.ticketingservice.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
