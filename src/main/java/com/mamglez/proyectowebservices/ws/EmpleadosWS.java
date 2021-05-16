/**
 * 
 */
package com.mamglez.proyectowebservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mamglez.proyectowebservices.entity.Empleado;
import com.mamglez.proyectowebservices.service.EmpleadoService;

/**
 * @author skype
 *
 */
@Path("empleadoWS")
public class EmpleadosWS {

	private EmpleadoService empleadoService = new EmpleadoService();

	@Path("consultarEmpleado")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {
		return this.empleadoService.consultarEmpleado();

	}

	@Path("consultarEmpleados")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados() {
		return this.empleadoService.consultarEmpleados();
		
	}

	@Path("consultarEmpleadoPorNumeroEmpleado/{numEmp}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorNumeroEmpleado(@PathParam("numEmp") String numeroEmpleado ) {
		Empleado empleado =  this.empleadoService.consultarEmpleadoPorNumeroEmpleado(numeroEmpleado);
		if(empleado == null) {
			return Response.noContent().build();
		}
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}
	
	@Path("guardarEmpleado")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado ) {
		if(empleado == null) {
			return Response.status(400).entity("no se ingreso informacion del empleado").build();
		}
		if(empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("el nombre es requerido").build();
		}
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}
 
}
