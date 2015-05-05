package istic.sir.rest;

import istic.sir.jpa.Person;

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


@Path("/persons")
public class REST_Person {
	
	private List<Person> persons;
	private EntityManager em;
	
	public REST_Person(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		this.em = factory.createEntityManager();
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
		this.persons = query.getResultList();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons(){
		return persons;
	}
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonById(@PathParam("id") long id) {
	    TypedQuery<Person> queryNamed = em.createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class);
		return queryNamed.setParameter("id", id).getSingleResult();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person){
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		return Response.status(200).entity(true).build();
	}
	
	@DELETE 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removePersonById(@PathParam("id") long id) {
		Person p = em.find(Person.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		return Response.status(200).entity(true).build();
	}

}
