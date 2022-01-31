package next.xadmin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.xadmin.bean.Contact;
import next.xadmin.database.ContactDao;


@WebServlet("/Contacter")
public class Contacter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Contacter() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("name");
		String email = request.getParameter("email");
		String numero = request.getParameter("contactNumber");
		String message = request.getParameter("message");
		
		Contact contact = new Contact(firstname,email,numero,message);
		
		ContactDao cDao = new ContactDao();
		String result = cDao.insert(contact);
		
		response.sendRedirect("contact.jsp");
		
	}

}
