package ar.edu.unju.edm.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.tp4.model.Producto;
import ar.edu.unju.edm.tp4.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	@Qualifier("productoImp")
	ProductoService iProductoService;

	
	@GetMapping(value="/producto")
	public String inicioProducto(){
		return "productos";
	}
	
	@GetMapping(value="/producto/cargar")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return("cargar-producto");
	}
	
	@GetMapping(value="/producto/mostrar")
	public String mostrarProductos(Model model){
		model.addAttribute("producto", iProductoService.obtenerTodosProductos());
		return "mostrar-productos";
	}

	@GetMapping(value = "/producto/guardado")
	public String productoGuardaro(){
		return "producto-guardado";
	}

	@GetMapping(value="/ultimo")
	public String cargarUltimoProducto(Model model) {
		model.addAttribute("ultimoProducto", iProductoService.obtenerUltimoProducto());
		return("ultimo-productos");
	}
	
	@GetMapping(value="/volver")
	public String cargarNuevoProducto(Model model) {
		//model.addAttribute("unProducto", iiProductoService.obtenerProductoNuevo());
		return("redirect:/producto");
	}

	@PostMapping(value = "/producto/guardar")
	public String guardarProducto(@ModelAttribute("unProducto") Producto nuevoProducto) {
		iProductoService.guardarProducto(nuevoProducto);
		return("redirect:/producto/guardado");
	}
}
