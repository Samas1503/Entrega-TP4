package ar.edu.unju.edm.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.tp4.model.Producto;
import ar.edu.unju.edm.tp4.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	@Qualifier("productoImp")
	ProductoService iProductoService;

	//GET
	
	@GetMapping(value="/producto")
	public String inicioProducto(){
		return "productos";
	}
	
	@GetMapping(value="/producto/registrar")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return("cargar-producto");
	}
	
	@GetMapping(value="/producto/mostrar")
	public String mostrarProductos(Model model){
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return "mostrar-productos";
	}

	@GetMapping(value = "/producto/guardado")
	public String productoGuardado(){
		return "producto-guardado";
	}
	
	@GetMapping(value="/producto/editar/{codProducto}")
    public ModelAndView editandoCliente(@PathVariable(name = "codProducto") int cod){
        ModelAndView model = new ModelAndView("modificar-producto");
        Producto encontrado = iProductoService.obtenerUnProducto(cod);
        model.addObject("unProducto", encontrado);
        return model;
    }

	@GetMapping(value="/producto/eliminar/{codProducto}")
	public String eliminarCliente(@PathVariable(name = "codProducto")int cod,Model model) throws Exception{
		try {
			iProductoService.eliminarProducto(cod);
		} catch (Exception e) {
			model.addAttribute("usuarioErrorMensaje", e.getMessage());
		}
		return "redirect:/producto/mostrar";
	}

	//POST

	@PostMapping(value = "/producto/guardar")
	public String guardarProducto(@ModelAttribute("unProducto") Producto nuevoProducto) {
		iProductoService.guardarProducto(nuevoProducto);
		return("redirect:/producto/guardado");
	}
	@PostMapping(value="/producto/modificar")
	public String modificarCliente(@ModelAttribute("unCliente") Producto clienteModificado){
		iProductoService.modificarProducto(clienteModificado);
		return "redirect:/producto/mostrar";
	}
}
