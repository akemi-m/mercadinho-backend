package espm.data;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(name = "data", url = "http://data:8080")
public interface DataController {

    @GetMapping("/data/import/{nomeSensor}")
    public List<Map<String, ?>> acquire(@PathVariable String nomeSensor);

    @GetMapping("/data/export/{id}")
    public List<Map<String, ?>> export(@PathVariable String id);

}
