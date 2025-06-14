package espm.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPresencaRepository extends CrudRepository<DataPresencaModel, Integer> {

	@Query("SELECT MAX(c.idRegistro) FROM DataPresencaModel c")
	public Integer maiorIdPresenca();

	public List<DataPresencaModel> findAll();
}
