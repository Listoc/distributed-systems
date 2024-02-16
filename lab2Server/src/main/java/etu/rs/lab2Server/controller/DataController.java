package etu.rs.lab2Server.controller;


import etu.rs.lab2Server.model.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @PostMapping("/")
    public Data resultData(@RequestBody Data data) {
        data.setResult(data.getAmount() * data.getRate());

        return data;
    }

}
