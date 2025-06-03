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
@Table(name = "sensorpresenca") // nome da tabela para persistencia
@Getter
@Setter
@Accessors(fluent = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataPresencaModel {

  @Id
  @Column(name = "Id_RegP")
  private Integer idRegistro;

  @Column(name = "Dt_SenP")
  private Date dataSensor;

  @Column(name = "Tm_SenP")
  private Integer tempo;

  @Column(name = "Oc_Sens")
  private Integer ocupado;

  @Column(name = "Id_SenP")
  private Integer idSensor;

  // ORM: Objeto -> Relacional
  public DataPresencaModel(DataPresenca a) {
    this.idRegistro = a.idRegistro();
    this.dataSensor = a.dataSensor();
    this.tempo = a.tempo();
    this.ocupado = a.ocupado();
    this.idSensor = a.idSensor();
  }

  // ORM: Relacional -> Objeto
  public DataPresenca to() {
    return DataPresenca.builder()
        .idRegistro(this.idRegistro)
        .dataSensor(this.dataSensor)
        .tempo(this.tempo)
        .ocupado(this.ocupado)
        .idSensor(this.idSensor)
        .build();
  }

}
