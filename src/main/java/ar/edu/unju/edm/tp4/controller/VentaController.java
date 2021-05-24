package ar.edu.unju.edm.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.tp4.service.ProductoService;

@Controller
public class VentaController {
    
	@Autowired
	@Qualifier("mysqlProductosImp")
	ProductoService iProductoService;
    
	@GetMapping(value="/producto/catalogo")
	public ModelAndView mostrarCatalogo(Model model){
		ModelAndView modelo = new ModelAndView("mostrar-catalogo");
		modelo.addObject("productos", iProductoService.obtenerTodosProductos());
		return modelo;
	}
	
}
