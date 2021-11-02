package edu.gmu.swe642;

public class StudentBean {
	private String StudentId;
	private String UserName;
	private String Address;
	private String City;
	private String States;

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		this.StudentId = studentId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getStates() {
		return States;
	}

	public void setStates(String states) {
		this.States = states;
	}

}
