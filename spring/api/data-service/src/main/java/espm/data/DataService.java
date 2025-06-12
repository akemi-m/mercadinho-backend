package espm.data;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.bouncycastle.util.test.FixedSecureRandom.Data;
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

        if (sensor.equals("presense")) {
            Integer found = presencaRepository.maiorIdPresenca();
            logger.debug(found.toString());

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
                DataContatoRepository.save(DataContatoModel.builder()
                        .idRegistro(Integer.parseInt(a.get("idRegistro").toString()))
                        .dataSensor(LocalDateTime(a.get("dataSensor").toString()))
                        .tempo(a.get("tempo"))
                        .aberto(a.get("aberto"))
                        .idSensor(a.get("idSensor"))
                        .build());
            }
        }

        if (sensor.equals("presense")) {
            for (Map<String, ?> a : data) {
                DataPresencaRepository.save(DataPresencaModel.builder()
                        .idRegistro(a.get("idRegistro"))
                        .dataSensor(a.get("dataSensor"))
                        .tempo(a.get("tempo"))
                        .ocupado(a.get("aberto"))
                        .idSensor(a.get("idSensor"))
                        .build());
            }

        }

        if (sensor.equals("passage")) {

            for (Map<String, ?> a : data) {
                DataPassagemRepository.save(DataPassagemModel.builder()
                        .idRegistro((Integer) a.get("idRegistro"))
                        .dataSensor((Date) a.get("dataSensor"))
                        .entrada((Integer) a.get("tempo"))
                        .saida((Integer) a.get("ocupado"))
                        .idSensor((Integer) a.get("idSensor"))
                        .build());
            }

        }

        return data;

        // TODO: Adicionar no DB
    }

    public List<Map<String, ?>> post(String sensor) {

    }

}
