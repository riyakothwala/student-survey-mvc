package edu.gmu.swe642;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	private final String url = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
	// Enter your GMU Oracle credentials here.
	private final String userid = "<user-name>";
	private final String pwd = "<password>";

	/**
	 * TODO:
	 * 
	 * @param student
	 * @return
	 * @throws ClassNotFoundException
	 */
	// TODO: handle duplicate key scenario
	public int insertStudent(StudentBean student) throws ClassNotFoundException {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(url, userid, pwd);

			// Insert student data into database
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into students values(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getUserName());
			preparedStatement.setString(3, student.getAddress());
			preparedStatement.setString(4, student.getCity());
			preparedStatement.setString(5, student.getStates());

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle sql exception
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * TODO:
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getStudent() throws ClassNotFoundException {
		List dataList = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(url, userid, pwd);

			// Retrieve all student records
			Statement s = connection.createStatement();
			s.executeQuery("select * from students");
			ResultSet rs = s.getResultSet();
			while (rs.next()) {

				// Add records into data list
				dataList.add(rs.getString("StudentId"));
				dataList.add(rs.getString("UserName"));
				dataList.add(rs.getString("Address"));
				dataList.add(rs.getString("City"));
				dataList.add(rs.getString("States"));
			}
			rs.close();

			s.close();
		} catch (SQLException e) {
			// TODO: handle sql exception
			e.printStackTrace();
		}

		return dataList;
	}
}
