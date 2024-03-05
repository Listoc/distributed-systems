package etu.consumer.controller;

import etu.shared.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ConsumerController {
    private final List<User> userList = new LinkedList<>();

    @KafkaListener(id = "myId", topics = "topic2", containerFactory = "kafkaListenerContainerFactory")
    public void listen(User user) {
        userList.add(user);
    }

    @RequestMapping("/start")
    public String start(Model model) {
        if (userList.isEmpty()) {
            return "nodata";
        }

        model.addAttribute("user", userList.getFirst());
        userList.removeFirst();

        return "info";
    }
}
