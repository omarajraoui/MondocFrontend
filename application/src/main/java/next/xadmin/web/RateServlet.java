package next.xadmin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.Member;
import next.xadmin.bean.LoginBean;
import next.xadmin.bean.Rating;
import next.xadmin.database.LoginDao;
import next.xadmin.database.RatingDao;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RateServlet")
public class RateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RatingDao ratingDao = new RatingDao();
		
		int ratingNumber = Integer.parseInt(request.getParameter("rating"));
		String review = request.getParameter("review");
		String doctorName=request.getParameter("doctorName");
				
		Rating rate=new Rating();
		
		rate.setRatingNumber(ratingNumber);
		rate.setReview(review);
		rate.setDoctorName(doctorName);
	
		if (ratingDao.validate(rate))
		{
			response.sendRedirect("rate.jsp");
			
		}
		else 
		{
			response.sendRedirect("rate.jsp");			
		}
		
	}

}
