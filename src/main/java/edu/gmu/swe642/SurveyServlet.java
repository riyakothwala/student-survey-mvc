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
		String[] inputNumbers = request.getParameter("data").split(",");

		StudentBean studentBean = new StudentBean();
		studentBean.setStudentId(studentid);
		studentBean.setUserName(username);
		studentBean.setAddress(address);
		studentBean.setCity(city);
		studentBean.setStates(states);

		try {

			// 1) uses the studentDAO to store the student data to DB
			studentDao.insertStudent(studentBean);

			// 2)calls a method on DataProcessor to compute mean and standard deviation

			DataProcessor processor = new DataProcessor();
			DataBean dataBean = processor.computeMeanAndDeviation(inputNumbers);

			// assign calculated mean value from processor.
			Double mean = dataBean.getMean();
			String standardDev = dataBean.getStandardDev();

			// Retrieving student data from database
			List datalist = studentDao.getAllStudentIds();
			
			// Set student data, mean, and standard deviation in the request
			request.setAttribute("data", datalist);
			request.setAttribute("mean", mean);
			request.setAttribute("standardDev", standardDev);

			String nextPage = null;

			// Forward request to appropriate JSP page
			if (mean < 90) {
				// Set next page to be simple ack JSP
				nextPage = "SimpleAcknowledgement.jsp";
			} else {
				// Set next page to be winner ack JSP
				nextPage = "WinnerAcknowledgement.jsp";
			}

			// Now, forward request to next JSP page
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle all exceptions
			e.printStackTrace();
		}
	}
}
