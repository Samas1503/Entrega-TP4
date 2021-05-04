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
    @Qualifier("clienteImp")
    IClienteService clienteService;

    
    @GetMapping(value="/")
    public String principal(Model modelo){
        return "inicio";
    }

    @GetMapping(value="/ingresarUsuario")
    public String ingresar(Model modelo){
        modelo.addAttribute("ingresante", clienteService.crearCliente());
        return "index";
    }

    @GetMapping(value="/registrarse")
    public String registrarCliente(Model model){
        model.addAttribute("unCliente", clienteService.crearCliente());
        return "registro";
    }

    @GetMapping(value="/registrado")
    public String registradoCliente(){
        return "registrado";
    }

    @GetMapping(value="/cliente")
    public String clienteOpciones(Model modelo){
        return "cliente";
    }
    
    @GetMapping(value="/cliente/mostrar")
    public String cargarCliente(Model modelo){
        modelo.addAttribute("clientes", clienteService.obtenerTodosClientes());
        return "mostrar-clientes";
    }
    
    @GetMapping(value="/cliente/editar/{nroDocumento}")
    public ModelAndView editandoCliente(@PathVariable(name = "nroDocumento") int dni){
        ModelAndView model = new ModelAndView("modificar-cliente");
        Clientes encontrado = clienteService.buscarCliente(dni);
        System.out.println(encontrado);
        model.addObject("unCliente", encontrado);
        return model;
    }

	@GetMapping("/cliente/eliminar/{nroDocumento}")
	public String eliminarCliente(@PathVariable(name = "nroDocumento")int dni,Model model) throws Exception{
		try {
			clienteService.eliminarCliente(dni);
		} catch (Exception e) {
			model.addAttribute("usuarioErrorMensaje", e.getMessage());
		}
		return "redirect:/cliente/mostrar";
	}

    //POST

    @PostMapping(value="/ingresarUsuario")
    public String ingresarUsuario(@ModelAttribute("ingresante") Clientes ing){
        if(clienteService.verificarCliente(ing.getTipoDoc(), ing.getNroDocumento(), ing.getPassword())){
            return "/inicio";
        }
        else{
            return "index";
        }
    }

    @PostMapping(value="/cliente/guardar")
    public String guardarCliente(@ModelAttribute("unCliente") Clientes nuevoCliente){
        clienteService.guardarCliente(nuevoCliente);
        return "redirect:/registrado";
    }
    
	@PostMapping("/cliente/modificar")
	public String modificarCliente(@ModelAttribute("unCliente") Clientes clienteModificado){
		clienteService.modificarCliente(clienteModificado);
		return "redirect:/cliente/mostrar";
	}
    
}
