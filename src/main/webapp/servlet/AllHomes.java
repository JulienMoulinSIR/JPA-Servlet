package servlet;

import istic.sir.jpa.Home;

import java.io.IOException;
import java.util.List;

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


@WebServlet(name="allHomes", urlPatterns={"/homes"})
public class AllHomes extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Home> query = em.createQuery("SELECT h FROM Home h", Home.class);

		List<Home> homes = query.getResultList();
		
		try {
			ServletOutputStream out = response.getOutputStream();
			new PrintHTML().printHeader(out);
			out.println("<h1>"+homes.size()+" maisons trouvées.</h1><br>");
			out.println("<table class='table'>");
			out.println("<tr>");
			out.println("<th>Nombre de pièce</th>");
			out.println("<th>Superficie</th>");
			out.println("<th>Adresse</th>");
			out.println("<th>IP</th>");
			out.println("</tr>");
			for(Home h : homes) {
				out.println("<tr>");
				out.println("<td>");
				out.println(h.getNbRoom());
				out.println("</td>");
				out.println("<td>");
				out.println(h.getSurface());
				out.println("</td>");
				out.println("<td>");
				out.println(h.getAddress());
				out.println("</td>");
				out.println("<td>");
				out.println(h.getIPaddress());
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