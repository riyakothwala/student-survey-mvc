package edu.gmu.swe642;

import java.util.List;

public interface StudentDAO {

	/**
	 * TODO:
	 * 
	 * @param student
	 * @return
	 * @throws ClassNotFoundException
	 */
	// TODO: handle duplicate key scenario
	int insertStudent(StudentBean student) throws ClassNotFoundException;

	/**
	 * TODO:
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	List<String> getAllStudentIds() throws ClassNotFoundException;

	StudentBean getStudentById(String studentId) throws ClassNotFoundException;

}