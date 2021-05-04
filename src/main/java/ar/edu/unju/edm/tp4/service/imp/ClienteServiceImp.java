package ar.edu.unju.edm.tp4.service.imp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Clientes;
import ar.edu.unju.edm.tp4.service.IClienteService;
import ar.edu.unju.edm.tp4.util.ListaDeClientes;

@Service
@Qualifier("clienteImp")
public class ClienteServiceImp implements IClienteService{
    private List<Clientes> listadoClientes = ListaDeClientes.clientes;
	
	@Autowired
	Clientes unCliente;

	public void guardarCliente(Clientes unCliente) {
		LocalDate fechaN = unCliente.getFechaNac();
		LocalDate fechaA = LocalDate.now();
		LocalTime horaA = LocalTime.now();
		LocalTime horaM = LocalTime.of(23, 59, 59);
		Period periodo=Period.between(fechaN, fechaA);
		unCliente.setEdad(periodo.getYears());
		String datos = "TUC: ";
		periodo = Period.between(unCliente.getFechaUltimaCompra(), fechaA);
		datos = datos + (periodo.getYears() + " año(s) " + periodo.getMonths() + " mes(es) " + periodo.getDays() + " dia(s) THC: ");
		
		//Actualizacion de la fecha de nacimiento para convertirlo en fecha de cumpleaños
		fechaN = LocalDate.of(fechaA.getYear(),fechaN.getMonthValue(),fechaN.getDayOfMonth());
		
		if(fechaA.getMonthValue()!=fechaN.getMonthValue() && fechaA.getDayOfMonth()!=fechaN.getDayOfMonth()){
			//Calculo del periodo faltante para el proximo cumpleaños
			if(fechaA.getMonthValue() > fechaN.getMonthValue()){
				periodo = Period.between(fechaA, LocalDate.of(fechaN.getYear()+1,fechaN.getMonth(),fechaN.getDayOfMonth()));
			} else if (fechaA.getMonthValue() < fechaN.getMonthValue()){
				periodo = Period.between(fechaA, fechaN);
			} else if (fechaA.getMonthValue()==fechaN.getMonthValue()){
				if (fechaA.getDayOfMonth() > fechaN.getDayOfMonth()){
					periodo = Period.between(fechaA, LocalDate.of(fechaN.getYear()+1,fechaN.getMonth(),fechaN.getDayOfMonth()));
				} else {
					periodo = Period.between(fechaA, fechaN);
				}
			}
			//resto un dia del periodo calculado para calcular las horas minutos y segundos restantes
			if(periodo.getDays()==1){
				if(periodo.getMonths()==1){
					periodo = Period.of(periodo.getYears()-1, periodo.getMonths()-1, periodo.getDays()-1);
				}else{
					periodo = Period.of(periodo.getYears(), periodo.getMonths()-1, periodo.getDays()-1);
				}
			} else {
				periodo = Period.of(periodo.getYears(), periodo.getMonths(), periodo.getDays()-1);
			}
			horaM = horaM.minusHours(horaA.getHour());
			horaM = horaM.minusHours(horaA.getHour());
			horaM = horaM.minusMinutes(horaA.getMinute());
			horaM = horaM.minusSeconds(horaA.getSecond());
			datos += periodo.getYears() + " año(s) " + periodo.getMonths() + " mes(es) " + periodo.getDays() + " dia(s) " + horaM.getHour() + ":" + horaM.getMinute() + ":" + horaM.getSecond();
		} else{
			System.out.println(datos);
			datos += " Feliz Cumpleaños";
		}
			unCliente.setDatos(datos);
		listadoClientes.add(unCliente);
	}

	public Clientes crearCliente() {
		return unCliente;
	}

	public List<Clientes> obtenerTodosClientes() {
		return listadoClientes;
	}

	public boolean verificarCliente(String tipo, int numDoc, String password){
		int i=0;
		boolean band=false;
		for(i=0;i<listadoClientes.size();i++){
			if(tipo==listadoClientes.get(i).getTipoDoc() && numDoc==listadoClientes.get(i).getNroDocumento() && password==listadoClientes.get(i).getPassword()){
				band=true;
				break;
			}
		}
		return band;
	}
	public Clientes buscarCliente(int dni){
		int i;
		for(i=0;i<listadoClientes.size();i++){
			if(listadoClientes.get(i).getNroDocumento() == dni){
				break;
			}
		}
		return listadoClientes.get(i);
	}

	@Override
	public void modificarCliente(Clientes clienteModificado) {
		for (int i = 0; i < listadoClientes.size(); i++) {
			if (listadoClientes.get(i).getNroDocumento() == clienteModificado.getNroDocumento()) {
				listadoClientes.set(i, clienteModificado);
				break;
			}
		}
	}

	public void eliminarCliente(int dni){
		for (int i = 0; i < listadoClientes.size(); i++) {
			if (listadoClientes.get(i).getNroDocumento() == dni) {
				listadoClientes.remove(i);
				break;
			}
		}
	}

}
