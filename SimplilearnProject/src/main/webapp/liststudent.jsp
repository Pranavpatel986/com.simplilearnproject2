<%@page import="java.util.List"%>
<%@page import="com.Simpli.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style2.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="navbar">
		<div class="dropdown">
				<a href="createStudent.jsp">Add New Student</a> 
				<a href="welcome.jsp">Home</a> 
		</div>
	</div>
	<div class="container">
		<h2>List of Students</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Class</th>
				<th>Action</th>
				<c:forEach var="Student" items="${students}">
					<tr>
						<td><c:out value="${Student.id}"/></td>
						<td><c:out value="${Student.name}"/></td>
						<td><c:out value="${Student.email}"/></td>
						<td><c:out value="${Student.classRoom.id}"/></td>
						<td>
							<a href="edit?id=${Student.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?id=${Student.id}">Delete</a>
						</td>
					</tr>
					
					
				</c:forEach>
			</tr>
			
		</table>
	</div>
</body>
</html>