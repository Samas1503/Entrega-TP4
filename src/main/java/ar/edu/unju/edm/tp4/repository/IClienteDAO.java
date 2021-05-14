package ar.edu.unju.edm.tp4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tp4.model.Clientes;

@Repository
public interface IClienteDAO extends CrudRepository<Clientes, Integer>{

	@Query("from Clientes c order by c.nroDocumento")
	public List<Clientes> obtenerClientes();
}
