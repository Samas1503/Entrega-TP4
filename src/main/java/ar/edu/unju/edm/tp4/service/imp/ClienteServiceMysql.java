package ar.edu.unju.edm.tp4.service.imp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tp4.model.Clientes;
import ar.edu.unju.edm.tp4.repository.IClienteDAO;
import ar.edu.unju.edm.tp4.service.IClienteService;


@Service
@Qualifier("mysqlImp")
public class ClienteServiceMysql implements IClienteService{

    @Autowired
    Clientes unCliente;

    @Autowired
    IClienteDAO clienteDAO;

    @Override
    public void guardarCliente(Clientes unCliente) {
        clienteDAO.save(unCliente);
    }

    @Override
    public void adiconalesCliente(Clientes unCliente) {
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
			datos += " Feliz Cumpleaños";
		}
		unCliente.setDatos(datos);
    }

    @Override
    public Clientes crearCliente() {
        return unCliente;
    }

    @Override
    public List<Clientes> obtenerTodosClientes() {
        return (List<Clientes>) clienteDAO.findAll();
    }

    @Override
    public boolean verificarCliente(String tipo, int numDoc, String password) {
		boolean band=false;
        if(clienteDAO.findById(numDoc)!=null){
			if(tipo==clienteDAO.findById(numDoc).get().getTipoDoc() && password==clienteDAO.findById(numDoc).get().getPassword()){
				band=true;
			}
        }
		return band;
    }

    @Override
    public Clientes buscarCliente(int dni) throws Exception{
        return clienteDAO.findById(dni).orElseThrow(()->new Exception("El usuario NO existe"));
    }

    @Override
    public void modificarCliente(Clientes clienteModificado) {
        clienteDAO.save(unCliente);
    }

    @Override
    public void eliminarCliente(int dni) {
        clienteDAO.deleteById(dni);
    }
    
}
