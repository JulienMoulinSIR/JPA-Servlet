package istic.sir.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class JpaTest {

	private EntityManager em;

	public JpaTest(EntityManager em) {
		this.em = em;
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		EntityManager em = factory.createEntityManager();
		JpaTest test = new JpaTest(em);

		em.getTransaction().begin();
		
		Person p = new Person();
		p.setFirstName("Julien");
		p.setLastName("Moulin");
		p.setGender("Homme");
		p.setEmail("julien.moulin.1@etudiant.univ-rennes1.fr");
		p.setBirthday(new Date(1990, 12 ,29));
		p.setFbProfil("JulienMoulin");
		p.setFriends(new GenerateData().generatePersons());
		p.setHomes(new GenerateData().generateHomes());
		
		em.persist(p);
		em.getTransaction().commit();

		// TODO run request
		
		// basic query
		System.out.println("\nBasic query : SELECT p FROM Person p");
		List<Person> query = em.createQuery("SELECT p FROM Person p ", Person.class).getResultList();
		for(Person person : query){
			System.out.println(person.getFirstName()+" "+person.getLastName()+" "+person.getEmail());
		}
				
		// query named
		System.out.println("\nNamed query : SELECT p FROM Person p WHERE p.name = :name");
	    TypedQuery<Person> queryNamed = em.createQuery("SELECT p FROM Person p WHERE p.lastName = :name", Person.class);
		Person resultQueryNamed = queryNamed.setParameter("name", "Villeneuve").getSingleResult();
		System.out.println(resultQueryNamed.getFirstName()+" "+resultQueryNamed.getLastName()+" "+resultQueryNamed.getEmail());
		
		// criteria query
		System.out.println("\nCriteria query :");
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = builder.createQuery();
		Root<Person> from = criteriaQuery.from(Person.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		for(Object o : typedQuery.getResultList()){
			System.out.println(o);
		}
		
		System.out.println("\n.. done");
	}
	

}
