package edu.gmu.swe642;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	public int insertStudent(StudentBean student) throws ClassNotFoundException {

		int result = 0;
		String url = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
		// Enter your GMU Oracle credentials here.
		String userid = "<username>";
		String pwd = "<password>";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(url, userid, pwd);

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into students1 values(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getUserName());
			preparedStatement.setString(3, student.getAddress());
			preparedStatement.setString(4, student.getCity());
			preparedStatement.setString(5, student.getStates());

			// System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}
		return result;
	}
}
