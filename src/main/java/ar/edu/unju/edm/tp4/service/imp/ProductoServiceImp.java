package ar.edu.unju.edm.tp4.service.imp;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Producto;
import ar.edu.unju.edm.tp4.service.ProductoService;

@Service
@Qualifier("productoImp")
public class ProductoServiceImp implements ProductoService{
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
    	//como se hace la solucion del problema
		//guardar en Array		
		//guarde en una BD MySQL		
		//guarde en una DB Oracle
	
		@Autowired
		Producto unProducto;
		
		//estoy creando una estructura que guardará todos los productos
		ArrayList<Producto> listaDeProductos = new ArrayList<Producto>();
		
		public void guardarProducto(Producto unProducto) {
			//esta línea la puse solo para que escriba en la consola el nombre del producto que llega
			//una línea que me sirve a mí de control
			//un log artesanal
			System.out.println(unProducto.getNombre());
			listaDeProductos.add(unProducto);
			
			//otra línea de control
			//quiero saber cuántos elementos hay en el arreglo
			System.out.println(listaDeProductos.size());
			
			LOGGER.info("METHOD: ingresando a Guardar Producto");
			LOGGER.info("RESULT: guardado " + listaDeProductos.get(listaDeProductos.size()-1).getNombre());
		}
	
		public void modificarProducto(Producto productoAModificar) {
			int i;
			for(i=0;i<listaDeProductos.size();i++){
				if(listaDeProductos.get(i).getCodProducto()==productoAModificar.getCodProducto())
					break;
			}
			listaDeProductos.remove(i);
			listaDeProductos.add(i, productoAModificar);
		}
	
		public void eliminarProducto(Producto productoAEliminar) {
			listaDeProductos.remove(productoAEliminar);
		}
	
		public Producto obtenerUnProducto(int cod) {
			int i;
			for(i=0;i<listaDeProductos.size();i++){
				if(listaDeProductos.get(i).getCodProducto()==cod)
					break;
			}
			return listaDeProductos.get(i);
		}
	
		public ArrayList<Producto> obtenerTodosProductos() {
			return listaDeProductos;
		}
	
		public Producto obtenerProductoNuevo() {
			return unProducto;
		}
	
		public Producto obtenerUltimoProducto() {
			return listaDeProductos.get(listaDeProductos.size() - 1);
		}
	

}
