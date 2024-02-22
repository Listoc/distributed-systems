package etu.lab3.controller;

import etu.lab3.model.DrugData;
import etu.lab3.proxy.ClientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private final Set<String> drugNameSet;
    private final Set<DrugData> drugDataSet;

    public MainController(ClientProxy clientProxy) {
        this.drugDataSet = clientProxy.getDrugs();
        this.drugNameSet = this.drugDataSet.stream().map((drug) -> drug.getTradename() + " " + drug.getDosageform()).collect(Collectors.toSet());
    }

    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("drugs", drugNameSet);
        return "index";
    }

    @PostMapping("/start")
    public String info(@RequestParam String tradeName, Model model) {
        var drug = drugDataSet.stream().filter((el) -> (el.getTradename() + " " + el.getDosageform()).equals(tradeName)).findFirst();

        if (drug.isEmpty()) {
            return "nosuch";
        } else {
            model.addAttribute("drug", drug.get());

            return "info";
        }
    }
}
