package corp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import corp.entity.Clientes;
import corp.repository.CorpRepository;

@RestController
public class CorpController {
	
	@Autowired
	CorpRepository corpRepository;
	
	@RequestMapping(value="/corporation", method = RequestMethod.GET)
	public List<Clientes> listCorp() {
		return this.corpRepository.findAll();
	}
	
	@RequestMapping(value="/corporation", method = RequestMethod.POST)
	public Clientes saveClientes(@RequestBody Clientes clientes) {
		return this.corpRepository.save(clientes);
	}
	
	@RequestMapping(value="/corporation/{id}", method = RequestMethod.GET)
	public Clientes findById(@PathVariable String id) {
		return this.corpRepository.findOne(id);
	}
	
	// pesquizar pelo nome Ex: corporation/Ciclano/name
	@RequestMapping(value="/corporation/{name}/name", method = RequestMethod.GET)
	public List<Clientes> findByName(@PathVariable String name) {
		return this.corpRepository.findByNameLikeIgnoreCase(name);
	}
}