package ar.edu.unju.edm.tp4.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Clientes;
import ar.edu.unju.edm.tp4.service.IClienteService;
import ar.edu.unju.edm.tp4.repository.IClienteDAO;

@Service
@Qualifier("dataBaseImp")
public class ClienteServiceMySQL implements IClienteService{

    @Autowired
	Clientes unCliente;
	
	@Autowired
	IClienteDAO clienteDAO;

    @Override
    public List<Clientes> obtenerTodosClientes() {
        return (List<Clientes>) clienteDAO.findAll();
    }

    @Override
    public boolean verificarCliente(String tipo, int numDoc, String password) {
        return false;
    }

    @Override
    public void guardarCliente(Clientes unCliente) {
        
    }

    @Override
    public void adiconalesCliente(Clientes unCliente) {
        
    }

    @Override
    public Clientes crearCliente() {
        return null;
    }

    @Override
    public Clientes buscarCliente(int dni) {
        return null;
    }

    @Override
    public void modificarCliente(Clientes clienteModificado) {
        
    }

    @Override
    public void eliminarCliente(int dni) {
        
    }
    
}
