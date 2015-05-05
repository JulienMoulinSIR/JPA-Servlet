package servlet;

import istic.sir.jpa.Person;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="addPerson", urlPatterns={"/person/add"})
public class AddPerson extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		EntityManager em = factory.createEntityManager();
		
		Person p = new Person();
		p.setLastName(request.getParameter("lastName"));
		p.setFirstName(request.getParameter("firstName"));
		p.setGender(request.getParameter("gender"));
		p.setEmail(request.getParameter("email"));
		try {
			p.setBirthday( new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p.setFbProfil(request.getParameter("fbprofil"));
		
		em.getTransaction().begin();	
		em.persist(p);
		em.getTransaction().commit();
		
		try {
			// out.write("") method is for java.io.Writer it is used to write the any file like text,csv.
			// out.println("") this one is servlet method and it is use for write data on browser.
			ServletOutputStream out = response.getOutputStream(); // 
			
			new PrintHTML().printHeader(out);
			out.println("<h1>Ajout effectue</h1>");
			out.println("<h3>Details :</h3>");
			out.println("<p>Nom : "+p.getLastName()+"</p>");
			out.println("<p>Prenom : "+p.getFirstName()+"</p>");
			out.println("<p>Genre : "+p.getGender()+"</p>");
			out.println("<p>Email : "+p.getEmail()+"</p>");
			out.println("<p>Date de naissance : "+p.getBirthday()+"</p>");
			out.println("<p>Facebook : "+p.getFbProfil()+"</p>");
			new PrintHTML().printFooter(out);
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}