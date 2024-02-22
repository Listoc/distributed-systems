package etu.lab3.proxy;

import etu.lab3.model.DrugData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(name="multiply", url = "https://minzdrav.gov.ru")
public interface ClientProxy {
    @GetMapping("/opendata/7707778246-gosreestrpredelnyhotpusknyhcen/data-20170210T1524-structure-20170208T1755.json")
    Set<DrugData> getDrugs();
}
