<%@page import="com.Simpli.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"  %>

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
				<a href="createteacher.jsp">Add New Teacher</a> 
				<a href="Teacher?teacher_action=list">List All Teacher</a>
		</div>
	</div>
	
	<div class="container">
		<h2>Teacher</h2>
	
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
			<tr>
				
				<td>${teacher.id}</td>
				<td>${teacher.name}</td>
				<td>${teacher.email}</td>
				<td></td>
				
			</tr>

		</table>
	</div>
	
</body>
</html>