package ar.edu.unju.edm.tp4.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Producto;
import ar.edu.unju.edm.tp4.service.ProductoService;
import ar.edu.unju.edm.tp4.util.ListaDeProductos;

@Service
@Qualifier("productoImp")
public class ProductoServiceImp implements ProductoService{
	private List<Producto> listadoProductos = ListaDeProductos.productos;
	
	@Autowired
	Producto unProducto;
			
	public void guardarProducto(Producto unProducto) {
			//esta línea la puse solo para que escriba en la consola el nombre del producto que llega
			//una línea que me sirve a mí de control
			listadoProductos.add(unProducto);
	}

	public void modificarProducto(Producto productoAModificar) {
		int i;
		for(i=0;i<listadoProductos.size();i++){
			if(listadoProductos.get(i).getCodProducto()==productoAModificar.getCodProducto())
				break;
		}
		listadoProductos.remove(i);
		listadoProductos.add(i, productoAModificar);
	}

	public void eliminarProducto(int cod) {
		for(int i=0;i<listadoProductos.size();i++){
			if(listadoProductos.get(i).getCodProducto()==cod){
				listadoProductos.remove(i);
			}
		}
	}

	public Producto obtenerUnProducto(int cod) {
		int i;
		for(i=0;i<listadoProductos.size();i++){
			if(listadoProductos.get(i).getCodProducto()==cod)
				break;
		}
		return listadoProductos.get(i);
	}

	public List<Producto> obtenerTodosProductos() {
		return listadoProductos;
	}

	public Producto obtenerProductoNuevo() {
		return unProducto;
	}

	public Producto obtenerUltimoProducto() {
		return listadoProductos.get(listadoProductos.size() - 1);
	}
}
