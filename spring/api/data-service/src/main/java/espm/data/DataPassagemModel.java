package espm.data;

import java.time.LocalDateTime;

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
@Table(name = "sensorpassagem") // nome da tabela para persistencia
@Getter
@Setter
@Accessors(fluent = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataPassagemModel {

	@Id
	@Column(name = "Id_RegF")
	private Integer idRegistro;

	@Column(name = "Dt_SenF")
	private LocalDateTime dataSensor;

	@Column(name = "En_SenF")
	private Integer entrada;

	@Column(name = "Sd_SenF")
	private Integer saida;

	@Column(name = "Id_SenF")
	private Integer idSensor;

	// ORM: Objeto -> Relacional
	public DataPassagemModel(DataPassagem a) {
		this.idRegistro = a.idRegistro();
		this.dataSensor = a.dataSensor();
		this.entrada = a.entrada();
		this.saida = a.saida();
		this.idSensor = a.idSensor();
	}

	// ORM: Relacional -> Objeto
	public DataPassagem to() {
		return DataPassagem.builder()
				.idRegistro(this.idRegistro)
				.dataSensor(this.dataSensor)
				.entrada(this.entrada)
				.saida(this.saida)
				.idSensor(this.idSensor)
				.build();
	}

}
