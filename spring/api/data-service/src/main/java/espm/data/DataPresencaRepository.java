package espm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DataPresencaRepository extends JpaRepository<DataPresenca, String> {

  @Query("SELECT MAX(Id_RegP) FROM data.sensorpresenca")
  public DataPresencaModel maiorIdPresenca();
}
