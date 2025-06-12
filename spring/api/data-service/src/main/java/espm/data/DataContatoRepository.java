package espm.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataContatoRepository extends CrudRepository<DataContatoModel, Integer> {

  @Query("SELECT MAX(c.idRegistro) FROM DataContatoModel c")
  public Integer maiorIdContato();

}
