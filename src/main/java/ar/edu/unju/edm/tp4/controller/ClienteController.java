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

import ar.edu.unju.edm.tp4.model.Clientes;
import ar.edu.unju.edm.tp4.service.IClienteService;

@Controller
public class ClienteController {
    @Autowired
    @Qualifier("mysqlClientesImp")
    IClienteService clienteService;

    //GET

    @GetMapping(value="/home")
    public String principal(Model modelo){
        return "inicio";
    }

    @GetMapping(value="/cliente")
    public String clienteOpciones(Model modelo){
        return "cliente";
    }

    @GetMapping(value="/cliente/registrar")
    public String registrarCliente(Model model){
        model.addAttribute("unCliente", clienteService.crearCliente());
        model.addAttribute("regreso", false);
        return "registrar-cliente";
    }
    
    @GetMapping(value="/cliente/registrado")
    public String registradoCliente(Model model){
        model.addAttribute("regreso", false);
        return "registrado";
    }
    
    @GetMapping(value="/cliente/mostrar")
    public String cargarCliente(Model modelo) throws Exception{
        modelo.addAttribute("clientes", clienteService.obtenerTodosClientes());
        return "mostrar-clientes";
    }
    
    @GetMapping(value="/cliente/editar/{nroDocumento}")
    public ModelAndView editandoCliente(@PathVariable(name = "nroDocumento") int dni) throws Exception{
        ModelAndView model = new ModelAndView("modificar-cliente");
        Clientes encontrado = clienteService.buscarCliente(dni);
        model.addObject("unCliente", encontrado);
        return model;
    }

	@GetMapping(value="/cliente/eliminar/{nroDocumento}")
	public String eliminarCliente(@PathVariable(name = "nroDocumento")int dni,Model model) throws Exception{
		try {
			clienteService.eliminarCliente(dni);
		} catch (Exception e) {
			model.addAttribute("usuarioErrorMensaje", e.getMessage());
		}
		return "redirect:/cliente/mostrar";
	}

    //POST

   @PostMapping(value="/cliente/guardar")
    public String guardarCliente(@ModelAttribute("unCliente") Clientes nuevoCliente){
        clienteService.adiconalesCliente(nuevoCliente);
        clienteService.guardarCliente(nuevoCliente);
        return "redirect:/cliente/registrado";
    }
    
	@PostMapping(value="/cliente/modificar")
	public String modificarCliente(@ModelAttribute("unCliente") Clientes clienteModificado) throws Exception{
        clienteService.adiconalesCliente(clienteModificado);
		clienteService.modificarCliente(clienteModificado);
		return "redirect:/cliente/mostrar";
	}
    
}
