package espm.data;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@Builder
public class DataPassagem {

  private Integer idRegistro;
  private Date dataSensor;
  private Integer entrada;
  private Integer saida;
  private Integer idSensor;

}
