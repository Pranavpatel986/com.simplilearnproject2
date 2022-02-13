<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style2.css">
<title>Student creation page</title>
</head>
<body>
	<div class="navbar">
		<div class="dropdown">
				<a href="Teacher?teacher_action=list">List All Teacher</a>
		</div>
	</div>
	
	

	<div class="container">
		<h1>Teacher</h1>
		<form action="Teacher" method="post">
			<table>
				<tr>
					<td>id:</td>
					<td><input type="text" name="id" placeholder="id"></td>
				</tr>
				<tr>
					<td><input type="hidden"  name="teacher_action" value="one"></td>
					<td><input type="submit" value="SUBMIT"></td>
				</tr>
			</table>
		</form>
		
	</div>
	
	
	<div class="container">

		<h1>Add new Teacher</h1>
		<form action="Teacher" method="post">
			 
			 <table> 
			 	<tr>
			 		<th>Name</th>
			 		<td><input type="text" name="teacher_Name"></td>
			 	</tr>
			 	<tr>
			 		<th>Email</th>
			 		<td><input type="email" name="teacher_email"></td>
			 	</tr>
			 	<tr>
			 		<th><input type="hidden" name="teacher_action" value="new"></th>
			 		<td>
			 			<input type="submit" value="SUBMIT">
			 		</td>
			 	</tr>
			 </table>
		</form>
		
	
		
	</div>
</body>
</html>