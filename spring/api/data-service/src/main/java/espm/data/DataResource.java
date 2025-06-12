package espm.data;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataResource {

    private static final Logger logger = LoggerFactory.getLogger(DataResource.class);

    @Autowired
    private DataService dataService;

    @GetMapping("/import/{nomeSensor}")
    public List<Map<String, ?>> acquire(@PathVariable("nomeSensor") String nomeSensor) {
        List<Map<String, ?>> teste = dataService.acquire(nomeSensor);
        return teste == null ? null : teste;
    }

    @GetMapping("/export/{id}")
    public List<Map<String, ?>> export(@PathVariable String id) {
        throw new UnsupportedOperationException("Unimplemented method 'export'");
    }

}
