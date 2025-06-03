package espm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DataPassagemRepository extends JpaRepository<DataPassagem, String> {

  @Query("SELECT MAX(Id_RegF) FROM data.sensorpassagem")
  public DataPassagemModel maiorIdPassagem();
}
