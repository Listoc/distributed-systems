package etu.rs.lab2.proxy;

import etu.rs.lab2.model.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "results", url = "${name.service.url}")
public interface ResultProxy {

    @PostMapping("/")
    Data resultData(@RequestBody Data data);

}
