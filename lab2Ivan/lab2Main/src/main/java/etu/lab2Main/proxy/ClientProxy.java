package etu.lab2Main.proxy;

import etu.lab2Main.model.UserData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="multiply", url = "localhost:8081")
public interface ClientProxy {
    @PostMapping("multiply")
    double multiply(@RequestBody UserData data);
}
