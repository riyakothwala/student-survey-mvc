# 642 HW3 Andrea Howes, Riya Modi

#Database Setup
First, install SQL Developer GUI using this link: https://www.oracle.com/tools/downloads/sqldev-downloads.html
Then, connect to GMU VPN and use the instructions located here: https://labs.vse.gmu.edu/index.php/Services/Oracle
to find your gmu oracle password and connect to your GMU oracle database.

Once connected, create a table named "students" in sqldeveloper,the DDL is below.
DDL for the students table is:
```
CREATE TABLE STUDENTS(
	StudentId varchar(12),
	UserName varchar(255),
	Address varchar(255),
	City varchar(25),
	States varchar(25),
	Zip varchar(25),
	Telephone varchar(25),
	Email varchar(25),
	Url varchar(25),
	Campuslikes varchar(100),
	Interested varchar(25),
	Notes varchar(25),
	GradMonth varchar(25),
	GradYear varchar(25),
	Recommend varchar(25),
	Data varchar(100),
	SurveyDate varchar(25),
	PRIMARY KEY (StudentId)
);
```

Second, update *\student-survey-mvc\src\main\resources\db-config.properties* file with your GMU Oracle credentials to connect to the database.
Also make sure you are connected to the GMU VPN.


# Individual contributions:

Andrea Howes: Created the DataBean and dataProcessor class. And made the student.jsp, NosuchStudent.jsp, SimpleAcknowledgement.jsp and SurveyServlet(get method). Made a demo video out of the running application.

Riya Modi: Created the skeleton maven project and added the SurveyServlet (post method) along with StudentBean, StudentDAO (Interface), StudentDAOImpl(Implementation of interface), StudentAlreadyExist.jsp and WinnerAcknowledgement.jsp.
