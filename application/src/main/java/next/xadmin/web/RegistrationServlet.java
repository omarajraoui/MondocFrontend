package next.xadmin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.Member;
import application.RegisterDao;
import next.xadmin.bean.LoginBean;
import next.xadmin.database.LoginDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao loginDao = new LoginDao();
		
		System.out.println("Inside Registraion Servlet....");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Member member=new Member();
		
		member.setFirstname(firstName);
		member.setLastname(lastName);
		member.setEmail(email);
		member.setPassword(password);	
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is : "+lastName);
		
		RegisterDao registerDao=new RegisterDao();
		
		String result=registerDao.insert(member);
		
		System.out.println(result);
		
		response.sendRedirect("login_user.jsp");		
	}

}
