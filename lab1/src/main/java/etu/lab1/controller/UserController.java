package etu.lab1.controller;

import etu.lab1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/start")
    public String info(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "info";
    }
}
