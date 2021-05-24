package ar.edu.unju.edm.tp4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tp4.model.Producto;

@Repository
public interface IProductoDAO extends CrudRepository<Producto, Integer> {
    
    @Query("from Producto c order by c.codProducto")
    public List<Producto> obtenProductos();

    public Optional<Producto> findByCodProducto(int cod);
}
