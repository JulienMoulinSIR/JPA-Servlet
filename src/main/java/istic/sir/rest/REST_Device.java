package istic.sir.rest;

import istic.sir.jpa.Device;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/devices")
public class REST_Device {
	
	private List<Device> devices;
	private EntityManager em;
	
	public REST_Device(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		this.em = factory.createEntityManager();
		TypedQuery<Device> query = em.createQuery("SELECT d FROM Device d", Device.class);
		this.devices = query.getResultList();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Device> getDevices(){
		return devices;
	}
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Device getDeviceById(@PathParam("id") long id) {
	    TypedQuery<Device> queryNamed = em.createQuery("SELECT d FROM Device d WHERE d.id = :id", Device.class);
		return queryNamed.setParameter("id", id).getSingleResult();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDevice(Device device){
		em.getTransaction().begin();
		em.persist(device);
		em.getTransaction().commit();
		return Response.status(200).entity(true).build();
	}
	
	@DELETE 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeDeviceById(@PathParam("id") long id) {
		Device d = em.find(Device.class, id);
		em.getTransaction().begin();
		em.remove(d);
		em.getTransaction().commit();
		return Response.status(200).entity(true).build();
	}

}