package ar.edu.unju.edm.tp4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Clientes;

@Service("clienteService")

public interface IClienteService {
//import org.springframework.stereotype.Service;
	public void guardarCliente(Clientes unCliente);
	public void adiconalesCliente(Clientes unCliente);
	public Clientes crearCliente();
	public List<Clientes> obtenerTodosClientes();
	public boolean verificarCliente(String tipo,int numDoc,String password);
	public Clientes buscarCliente(int dni) throws Exception;
	public void modificarCliente(Clientes clienteModificado);
	public void eliminarCliente(int dni) throws Exception;
}
