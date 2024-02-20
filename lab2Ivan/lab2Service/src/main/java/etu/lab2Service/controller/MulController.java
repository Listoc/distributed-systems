package etu.lab2Service.controller;

import etu.lab2Service.model.UserData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MulController {

    @PostMapping("/multiply")
    public Double multiply(@RequestBody UserData data) {
        return (double) data.getAmount() * data.getRate();
    }
}
