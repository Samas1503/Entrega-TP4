package ar.edu.unju.edm.tp4.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Producto;
import ar.edu.unju.edm.tp4.repository.IProductoDAO;
import ar.edu.unju.edm.tp4.service.ProductoService;

@Service
@Qualifier("mysqlProductosImp")
public class ProductoServiceMysql implements ProductoService{

    @Autowired
    Producto unProducto;

    @Autowired
    IProductoDAO iProductoDAO;

    @Override
    public void guardarProducto(Producto unProducto) {
        iProductoDAO.save(unProducto);
    }

    @Override
    public void modificarProducto(Producto productoAModificar) {
        iProductoDAO.save(productoAModificar);
    }

    @Override
    public void eliminarProducto(int cod) throws Exception {
        Producto productoEliminar=iProductoDAO.findByCodProducto(cod).orElseThrow(()->new Exception("Producto NO encontrado"));
        iProductoDAO.delete(productoEliminar);
    }

    @Override
    public Producto obtenerUnProducto(int cod) throws Exception {
        return iProductoDAO.findByCodProducto(cod).orElseThrow(()->new Exception("Producto NO Encontrado"));
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        return (List<Producto>) iProductoDAO.findAll();
    }

    @Override
    public Producto obtenerProductoNuevo() {
        return unProducto;
    }
}
