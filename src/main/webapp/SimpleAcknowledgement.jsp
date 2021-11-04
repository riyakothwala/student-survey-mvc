<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Acknowledgement</title>
</head>
<body>
	<h1>Thank you for filling out the form</h1>
	<%@page import="java.util.List"%>
	<%--Importing all the dependent classes--%>
	<%@page import="edu.gmu.swe642.StudentDao"%>
	<%@page import="java.util.Iterator"%>

	<%
	List data = (List) request.getAttribute("data");
	%>
	<table cellspacing="2" cellpadding="2">

		<tr>
			<th>Student ID</th>
		</tr>
		<%
		// Iterating through subjectList

		if (request.getAttribute("data") != null) // Null check for the object
		{
			Iterator iterator = data.iterator(); // Iterator interface

			while (iterator.hasNext()) // iterate through all the data until the last record
			{
		%>
		<tr>
			<td><a href="/"><%=iterator.next()%></a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>