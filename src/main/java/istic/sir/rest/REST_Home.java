package istic.sir.rest;

import istic.sir.jpa.Home;

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


@Path("/homes")
public class REST_Home {
	
	private List<Home> homes;
	private EntityManager em;
	
	public REST_Home(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		this.em = factory.createEntityManager();
		TypedQuery<Home> query = em.createQuery("SELECT h FROM Home h", Home.class);
		this.homes = query.getResultList();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> getHomes(){
		return homes;
	}
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Home getHomeById(@PathParam("id") long id) {
	    TypedQuery<Home> queryNamed = em.createQuery("SELECT h FROM Home h WHERE h.id = :id", Home.class);
		return queryNamed.setParameter("id", id).getSingleResult();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHome(Home home){
		em.getTransaction().begin();
		em.persist(home);
		em.getTransaction().commit();
		return Response.status(200).entity(true).build();
	}
	
	@DELETE 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeHomeById(@PathParam("id") long id) {
		Home h = em.find(Home.class, id);
		em.getTransaction().begin();
		em.remove(h);
		em.getTransaction().commit();
		return Response.status(200).entity(true).build();
	}

}