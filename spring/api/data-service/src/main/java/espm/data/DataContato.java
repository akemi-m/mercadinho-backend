package espm.data;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@Builder
public class DataContato {

    private Integer idRegistro;
    private LocalDateTime dataSensor;
    private Integer tempo;
    private Integer aberto;
    private Integer idSensor;

}
