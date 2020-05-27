package com.example.yakuba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String getSignUp(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String postSignUp(Model model) {

        return "redirect:/index";
    }
    @PostMapping("/logout")
    public String logout(Model model) {
    	return "redirect:/login";
    }

}

