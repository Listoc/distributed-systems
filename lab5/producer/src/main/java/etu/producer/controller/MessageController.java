package etu.producer.controller;

import etu.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {
    @Autowired
    private KafkaTemplate<String, User> template;

    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/start")
    public String sendData(@ModelAttribute("user") User user) {
        template.send("topic2", user);
        return "info";
    }

}
