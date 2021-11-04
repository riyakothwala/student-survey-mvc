package edu.gmu.swe642;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentDao {

	private static String URL;
	private static String USER_NAME;
	private static String PASSWORD;

	static {
		try (InputStream input = StudentDao.class.getClassLoader().getResourceAsStream("db-config.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			URL = prop.getProperty("db.url");
			USER_NAME = prop.getProperty("db.user");
			PASSWORD = prop.getProperty("db.password");

		} catch (IOException ex) {
			// TODO: handle scenario when failed to read file
			ex.printStackTrace();
		}
	}

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
			Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

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
	public List<String> getAllStudentIds() throws ClassNotFoundException {
		List<String> studentIdList = new ArrayList<String>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			// Retrieve all student records
			Statement s = connection.createStatement();
			s.executeQuery("select * from students");
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				// Add records into data list
				studentIdList.add(rs.getString("StudentId"));
			}
			rs.close();

			s.close();
		} catch (SQLException e) {
			// TODO: handle sql exception
			e.printStackTrace();
		}

		return studentIdList;
	}
}
