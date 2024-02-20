package etu.lab2Main.controller;

import etu.lab2Main.model.UserData;
import etu.lab2Main.proxy.ClientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final ClientProxy clientProxy;

    public MainController(ClientProxy clientProxy) {
        this.clientProxy = clientProxy;
    }

    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("userData", new UserData());
        return "index";
    }

    @PostMapping("/start")
    public String info(@ModelAttribute("userData") UserData userData, Model model) {
        double result = clientProxy.multiply(userData);
        model.addAttribute("result", result);
        return "info";
    }
}
