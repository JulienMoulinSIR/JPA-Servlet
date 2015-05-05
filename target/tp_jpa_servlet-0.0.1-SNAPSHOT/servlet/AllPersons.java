package servlet;

import java.io.IOException;
import java.util.List;

import istic.sir.tp_jpa_servlet.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="allPersons", urlPatterns={"/persons"})
public class AllPersons extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);

		List<Person> persons = query.getResultList();
		
		try {
			ServletOutputStream out = response.getOutputStream();
			new PrintHTML().printHeader(out);
			out.println("<h1>"+persons.size()+" personnes trouvees.</h1><br>");
			out.println("<table class='table'>");
			out.println("<tr>");
			out.println("<th>Nom</th>");
			out.println("<th>Prenom</th>");
			out.println("<th>Genre</th>");
			out.println("<th>Email</th>");
			out.println("<th>Date de naissance</th>");
			out.println("<th>FB Profile</th>");
			out.println("</tr>");
			for(Person p : persons) {
				out.println("<tr>");
				out.println("<td>");
				out.println(p.getLastName());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getFirstName());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getGender());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getEmail());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getBirthday().toString());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getFbProfil());
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			new PrintHTML().printFooter(out);
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			super.doPost(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}