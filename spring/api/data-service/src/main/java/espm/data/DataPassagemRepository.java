package espm.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPassagemRepository extends CrudRepository<DataPassagemModel, Integer> {

	@Query("SELECT MAX(c.idRegistro) FROM DataPassagemModel c")
	public Integer maiorIdPassagem();

	public List<DataPassagemModel> findAll();
}
