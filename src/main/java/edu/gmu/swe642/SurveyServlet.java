package edu.gmu.swe642;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
public class SurveyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		studentDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentid = request.getParameter("studentid").trim();
		String username = request.getParameter("name").trim();
		String address = request.getParameter("address").trim();
		String city = request.getParameter("city").trim();
		String states = request.getParameter("state").trim();

		StudentBean studentBean = new StudentBean();
		studentBean.setStudentId(studentid);
		studentBean.setUserName(username);
		studentBean.setAddress(address);
		studentBean.setCity(city);
		studentBean.setStates(states);

		try {

			// 1) uses the studentDAO to store the student data to DB
			studentDao.insertStudent(studentBean);

			// TODO: 2)calls a method on DataProcessor to compute mean and standard
			// deviation
			// DataProcessor processor = new DataProcessor();

			// TODO: assign calculated mean value from processor.
			double mean = 80; // hard coded for now

			// Forward request to appropriate JSP page
			if (mean < 90) {
				@SuppressWarnings("rawtypes")
				// Retrieving student data from database
				List datalist = studentDao.getStudent();
				// Set student data in the request
				request.setAttribute("data", datalist);
				// Now, forward request to JSP
				RequestDispatcher rd = request.getRequestDispatcher("SimpleAcknowledgement.jsp");
				rd.forward(request, response);
			} else {
				// TODO: complete this section later
				RequestDispatcher rd = request.getRequestDispatcher("WinnerAcknowledgement.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle all exceptions
			e.printStackTrace();
		}
	}
}
