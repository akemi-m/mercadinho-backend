package espm.data;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@Builder
public class DataPassagem {

	private Integer idRegistro;
	private LocalDateTime dataSensor;
	private Integer entrada;
	private Integer saida;
	private Integer idSensor;

}
