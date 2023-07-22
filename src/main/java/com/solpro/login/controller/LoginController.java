package com.solpro.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String asd(Model model) {

        return "home";
    }

    @GetMapping("/memberShip")
    public String asdf(Model model) {

        return "memberShip";
    }

    @PostMapping()
}
