package ar.edu.unju.edm.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.tp4.model.Clientes;
import ar.edu.unju.edm.tp4.service.IClienteService;

@Controller
public class UsuarioController {
    @Autowired
    @Qualifier("mysqlClientesImp")
    IClienteService clienteService;

    //GET

    @GetMapping(value="/")
    public String ingresar(Model modelo){
        modelo.addAttribute("ingresante", clienteService.crearCliente());
        return "index";
    }

    //POST

    @PostMapping(value="/ingresar")
    public String ingresarUsuario(@ModelAttribute("ingresante") Clientes ing,Model modelo){
        if(clienteService.verificarCliente(ing.getTipoDoc(), ing.getNroDocumento(), ing.getPassword())){
            return "redirect:/home";
        }
        else{
            return "redirect:/";
        }
    }

}
