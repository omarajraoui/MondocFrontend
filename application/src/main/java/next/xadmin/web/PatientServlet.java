package next.xadmin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.xadmin.bean.Patient;
import next.xadmin.database.PatientDao;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDao patientDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public PatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		patientDao = new PatientDao();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertPatient(request, response);
				break;
			case "/delete":
				deletePatient(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updatePatient(request, response);
				break;
			default:
				listPatient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("patient-form.jsp");
		dispatcher.forward(request, response);
	}
	private void insertPatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String docname = request.getParameter("docname");
		String speciality = request.getParameter("speciality");
		String rapport = request.getParameter("rapport");
		Patient newPatient = new Patient(firstname, lastname, docname, speciality,rapport);
		patientDao.insertPatient(newPatient);
		response.sendRedirect("list");
	}
	private void deletePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		patientDao.deletePatient(id);
		response.sendRedirect("list");

	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Patient existingPatient = patientDao.selectPatient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("patient-form.jsp");
		request.setAttribute("patient", existingPatient);
		dispatcher.forward(request, response);

	}
	private void updatePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String docname = request.getParameter("docname");
		String speciality = request.getParameter("speciality");
		String rapport = request.getParameter("rapport");

		Patient patient = new Patient(id,firstname, lastname, docname, speciality,rapport);
		patientDao.updatePatient(patient);
		response.sendRedirect("list");
	}
	private void listPatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Patient> patients = patientDao.selectAllPatients();
		request.setAttribute("listPatient",patients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("patient-list.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
