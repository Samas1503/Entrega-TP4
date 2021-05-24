package ar.edu.unju.edm.tp4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Producto;

@Service("productoService")
public interface ProductoService{
    public void guardarProducto(Producto unProducto);
	public void modificarProducto(Producto productoAModificar);
	public void eliminarProducto(int cod) throws Exception;
	public Producto obtenerUnProducto(int cod) throws Exception;
	public List<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
}