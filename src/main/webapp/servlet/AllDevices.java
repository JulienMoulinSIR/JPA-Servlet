package servlet;

import java.io.IOException;
import java.util.List;

import istic.sir.jpa.Device;

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


@WebServlet(name="allDevices", urlPatterns={"/devices"})
public class AllDevices extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql_home");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Device> query = em.createQuery("SELECT d FROM Device d", Device.class);

		List<Device> devices = query.getResultList();
		
		try {
			
			ServletOutputStream out = response.getOutputStream();
			
			new PrintHTML().printHeader(out);
			out.println("<h1>"+devices.size()+" appareils trouves.</h1><br>");
			out.println("<table class='table'>");
			out.println("<tr>");
			out.println("<th>Num</th>");
			out.println("<th>Consommation moyenne</th>");
			out.println("<th>Type</th>");
			out.println("</tr>");
			for(Device d : devices) {
				out.println("<tr>");
				out.println("<td>");
				out.println(d.getId());
				out.println("</td>");
				out.println("<td>");
				out.println(d.getConsumption_avg());
				out.println("</td>");
				out.println("<td>");
				out.println(d.getClass().getSimpleName());
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