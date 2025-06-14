package espm.data;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DataService {

    @Autowired
    private DataContatoRepository contatoRepository;

    @Autowired
    private DataPassagemRepository passagemRepository;

    @Autowired
    private DataPresencaRepository presencaRepository;

    private final Logger logger = LoggerFactory.getLogger(DataService.class);

    private final String URL = "https://iagen.espm.br/sensores/dados?sensor=%s&id_inferior=%d";

    public List<Map<String, ?>> acquire(String sensor) {
        int maiorId = 0;

        if (sensor.equals("magnetic")) {
            Integer found = contatoRepository.maiorIdContato();

            if (found != null) {
                maiorId = found;
            }
        }

        if (sensor.equals("presence")) {
            Integer found = presencaRepository.maiorIdPresenca();

            if (found != null) {
                maiorId = found;
            }
        }

        if (sensor.equals("passage")) {
            Integer found = passagemRepository.maiorIdPassagem();

            if (found != null) {
                maiorId = found;
            }
        }

        String uri = String.format(URL, sensor, maiorId);

        // Definindo o padrão de envio e recebimento,
        // definindo os headers da requisicao
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        // Definindo o request:
        // metodo: get
        // headers: tipos aceitaveis
        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers)
                .build();

        // Definindo a resposta, para o parser.
        // Aqui, estou esperando um
        // Map com chave string e valor sendo outro map (String, String)
        ParameterizedTypeReference<List<Map<String, ?>>> responseType = new ParameterizedTypeReference<>() {
        };

        // aqui, a requisicao esta sendo feita
        RestTemplate restTemplate = new RestTemplate();

        List<Map<String, ?>> data = restTemplate.exchange(request, responseType).getBody();

        logger.debug(data.toString());

        if (sensor.equals("magnetic")) {
            for (Map<String, ?> a : data) {
                contatoRepository.save(DataContatoModel.builder()
                        .idRegistro((Integer) a.get("id"))
                        .dataSensor(LocalDateTime.parse(a.get("data").toString(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .tempo((Integer) a.get("delta"))
                        .aberto((Integer) a.get("fechado"))
                        .idSensor((Integer) a.get("id_sensor"))
                        .build());
            }
        }

        if (sensor.equals("presence")) {
            for (Map<String, ?> a : data) {
                presencaRepository.save(DataPresencaModel.builder()
                        .idRegistro((Integer) a.get("id"))
                        .dataSensor(LocalDateTime.parse(a.get("data").toString(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .tempo((Integer) a.get("delta"))
                        .ocupado((Integer) a.get("ocupado"))
                        .idSensor((Integer) a.get("id_sensor"))
                        .build());
            }

        }

        if (sensor.equals("passage")) {

            for (Map<String, ?> a : data) {
                passagemRepository.save(DataPassagemModel.builder()
                        .idRegistro((Integer) a.get("id"))
                        .dataSensor(LocalDateTime.parse(a.get("data").toString(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .entrada((Integer) a.get("entrada"))
                        .saida((Integer) a.get("saida"))
                        .idSensor((Integer) a.get("id_sensor"))
                        .build());
            }

        }

        return data;

    }

    public List<Map<String, String>> export(String sensor) {

        if (sensor.equals("magnetic")) {
            return contatoRepository.findAll().stream().map(item -> {
                return Map.of("id_Registro", item.idRegistro().toString(),
                        "Data", item.dataSensor().toString(),
                        "Tempo", item.tempo().toString(),
                        "Aberto", item.aberto().toString(),
                        "Id_Sensor", item.idSensor().toString());
            }).toList();
        }

        if (sensor.equals("presence")) {
            return presencaRepository.findAll().stream().map(item -> {
                return Map.of("id_Registro", item.idRegistro().toString(),
                        "Data", item.dataSensor().toString(),
                        "Tempo", item.tempo().toString(),
                        "Ocupado", item.ocupado().toString(),
                        "Id_Sensor", item.idSensor().toString());
            }).toList();
        }

        if (sensor.equals("passage")) {
            return passagemRepository.findAll().stream().map(item -> {
                return Map.of("id_Registro", item.idRegistro().toString(),
                        "Data", item.dataSensor().toString(),
                        "Entrada", item.entrada().toString(),
                        "Saída", item.saida().toString(),
                        "Id_Sensor", item.idSensor().toString());
            }).toList();
        }
        return null;
    }
}
