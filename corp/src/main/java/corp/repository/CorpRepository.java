package corp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import corp.entity.Clientes;

public interface CorpRepository extends MongoRepository<Clientes, String> {
	
	public List<Clientes> findByNameLikeIgnoreCase(String name);
}
