package espm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DataContatoRepository extends JpaRepository<DataContato, String> {

  @Query("SELECT MAX(Id_RegC) FROM data.sensorcontato")
  public DataContatoModel maiorIdContato();

}
