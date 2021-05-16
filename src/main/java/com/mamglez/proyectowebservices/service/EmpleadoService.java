/**
 * 
 */
package com.mamglez.proyectowebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mamglez.proyectowebservices.entity.Empleado;

/**
 * @author skype
 *
 */
public class EmpleadoService {
	
	public Empleado consultarEmpleadoPorID(Long id) {
		return null;
	}
	
	public Empleado consultarEmpleadoPorNumeroEmpleado(String numeroEmpleado) {
		List<Empleado> empleados = this.consultarEmpleados();
		for(Empleado empleado : empleados) {
			if(empleado.getNumeroEmpleado().equals(numeroEmpleado)) {
				return empleado;
			}
		}
		return null;
	}
	
	public Empleado consultarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("2");
		empleado.setNombre("miguel");
		empleado.setPrimerApellido("martin");
		empleado.setSegundoApellido("gonzalez");
		empleado.setEdad(34);
		empleado.setFechaCreacion(LocalDateTime.now());
		return empleado;
	}
	
	public List<Empleado> consultarEmpleados(){
		List<Empleado> empleados = new ArrayList<>();
		
		Empleado empleado1 = new Empleado();
		empleado1.setNumeroEmpleado("2");
		empleado1.setNombre("miguel");
		empleado1.setPrimerApellido("martin");
		empleado1.setSegundoApellido("gonzalez");
		empleado1.setEdad(34);
		empleado1.setFechaCreacion(LocalDateTime.now());
		empleados.add(empleado1);
		
		Empleado empleado2 = new Empleado();
		empleado2.setNumeroEmpleado("3");
		empleado2.setNombre("miguela");
		empleado2.setPrimerApellido("martina");
		empleado2.setSegundoApellido("gonzaleza");
		empleado2.setEdad(34);
		empleado2.setFechaCreacion(LocalDateTime.now());
		empleados.add(empleado2);
		
		return empleados;
	}
	

}
