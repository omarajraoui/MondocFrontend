package next.xadmin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.xadmin.bean.Contact;
import next.xadmin.database.ContactDao;

@WebServlet("/index")
public class Router extends HttpServlet {

	
	 public Router() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			response.sendRedirect("index.jsp");
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String numero = request.getParameter("numero");
			String message = request.getParameter("message");
			
			Contact contact = new Contact(firstname,lastname,numero,message);
			
			ContactDao cDao = new ContactDao();
			String result = cDao.insert(contact);
			response.getWriter().print(result);
		}
}
