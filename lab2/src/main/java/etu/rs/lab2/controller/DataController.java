package etu.rs.lab2.controller;

import etu.rs.lab2.model.Data;
import etu.rs.lab2.proxy.ResultProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataController {

    //Внедрение и использование клиента OpenFeign
    private final ResultProxy resultProxy;

    public DataController(ResultProxy resultProxy) {
        this.resultProxy = resultProxy;
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("data", new Data());
        return "input";
    }

    @PostMapping("/")
    public String resultData(@ModelAttribute("data") Data data, Model model) {
        data = resultProxy.resultData(data);
        model.addAttribute("data", data);
        return "result";
    }
}