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
				<a href="CreateClass.jsp">Add New Class</a> 
				<a href="ClassRoom?class_action=list">List All Classes</a>
		</div>
	</div>
	
	<div class="container">
		<h2>Student</h2>
	
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Capacity</th>
			</tr>
			<tr>
				
				<td>${classRoom.id}</td>
				<td>${classRoom.classname}</td>
				<td>${classRoom.capacity}</td>
				<td></td>
				<td></td>
				
			</tr>

		</table>
	</div>
	
</body>
</html>