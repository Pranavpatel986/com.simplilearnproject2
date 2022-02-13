<%@page import="java.util.List"%>
<%@page import="com.Simpli.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<div class="navbar">
		<div class="dropdown">
				<a href="createteacher.jsp">Add New Teacher</a> 
				<a href="welcome.jsp">Home</a> 
		</div>
	</div>
	<div class="container">
		<h2>List of Teachers</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Actions</th>
				<c:forEach var="Teacher" items="${teachers}">
					<tr>
						<td><c:out value="${Teacher.id}"/></td>
						<td><c:out value="${Teacher.name}"/></td>
						<td><c:out value="${Teacher.email}"/></td>
						<td>
							<a href="edit?id=${Teacher.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?id=${Teacher.id}">Delete</a>
						</td>
					</tr>
					
					
				</c:forEach>
			</tr>
			
		</table>
	</div>
</body>
</html>