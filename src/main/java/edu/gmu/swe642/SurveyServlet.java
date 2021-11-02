package edu.gmu.swe642;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao StudentDao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		StudentDao=new StudentDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
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
		
		StudentBean StudentBean=new StudentBean();
		StudentBean.setStudentId(studentid);
		StudentBean.setUserName(username);
		StudentBean.setAddress(address);
		StudentBean.setCity(city);
		StudentBean.setStates(states);
		
		try {
            int no= StudentDao.insertStudent(StudentBean);
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"+ no +"row"
                        + "</b></body></html>");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		/* response.sendRedirect("StudentJsp.jsp"); */
	}

}
