package espm.data;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity // habilita o objeto para persistencia
@Table(name = "sensorcontato") // nome da tabela para persistencia
@Getter
@Setter
@Accessors(fluent = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataContatoModel {

  @Id
  @Column(name = "Id_RegC")
  private Integer idRegistro;

  @Column(name = "Dt_SenC")
  private Date dataSensor;

  @Column(name = "Tm_SenC")
  private Integer tempo;

  @Column(name = "Ab_SenC")
  private Integer aberto;

  @Column(name = "Id_SenC")
  private Integer idSensor;

  // ORM: Objeto -> Relacional
  public DataContatoModel(DataContato a) {
    this.idRegistro = a.idRegistro();
    this.dataSensor = a.dataSensor();
    this.tempo = a.tempo();
    this.aberto = a.aberto();
    this.idSensor = a.idSensor();
  }

  // ORM: Relacional -> Objeto
  public DataContato to() {
    return DataContato.builder()
        .idRegistro(this.idRegistro)
        .dataSensor(this.dataSensor)
        .tempo(this.tempo)
        .aberto(this.aberto)
        .idSensor(this.idSensor)
        .build();
  }

}
