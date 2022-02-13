<%@page import="java.util.List"%>
<%@page import="com.Simpli.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/style2.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="navbar">
		<div class="dropdown">
				<a href="CreateClass.jsp">Add New Class</a> 
				<a href="welcome.jsp">Home</a> 
		</div>
	</div>
	<div class="container">
		<h2>List of Classes</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Capacity</th>
				<th>Actions</th>
				<c:forEach var="Class" items="${classRooms}">
					<tr>
						<td><c:out value="${Class.id}"/></td>
						<td><c:out value="${Class.classname}"/></td>
						<td><c:out value="${Class.capacity}"/></td>					
						<td>
							<a href="edit?id=${Class.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?id=${Class.id}">Delete</a>
						</td>
					</tr>
					
					
				</c:forEach>
			</tr>
			
		</table>
	</div>
</body>
</html>