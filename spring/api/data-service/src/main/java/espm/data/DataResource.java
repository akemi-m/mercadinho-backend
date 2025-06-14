package espm.data;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataResource {

    @Autowired
    private DataService dataService;

    @GetMapping("/import/{nomeSensor}")
    public List<Map<String, ?>> acquire(@PathVariable("nomeSensor") String nomeSensor) {
        List<Map<String, ?>> teste = dataService.acquire(nomeSensor);
        return teste == null ? null : teste;
    }

    @GetMapping("/export/{nomeSensor}")
    public List<Map<String, String>> export(@PathVariable("nomeSensor") String nomeSensor) {
        List<Map<String, String>> teste = dataService.export(nomeSensor);
        return teste == null ? null : teste;
    }

}
