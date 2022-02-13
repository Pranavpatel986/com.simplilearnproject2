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
				<a href="Student?action=list">List All Students</a>
		</div>
	</div>
	
	

	<div class="container">
		<h1>Student</h1>
		<form action="Student" method="post">
			<table>
				<tr>
					<td>id:</td>
					<td><input type="text" name="id" placeholder="id"></td>
				</tr>
				<tr>
					<td><input type="hidden"  name="action" value="one"></td>
					<td><input type="submit" value="SUBMIT"></td>
				</tr>
			</table>
		</form>
		
	</div>
	
		<div class="container">

		<h1>Add new Student</h1>
		<form action="Student" method="post">
			 <table> 
			 	
			 	<tr>
			 		<th>Name</th>
			 		<td><input type="text" name="studentName"></td>
			 	</tr>
			 	<tr>
			 		<th>Email</th>
			 		<td><input type="email" name="email"></td>
			 	</tr>
			 	<tr>
			 		<th>Class</th>
			 		<td><input type="text" name="classroom"></td>
			 	</tr>
			 	<tr>
			 		<th><input type="hidden" name="action" value="new"></th>
			 		<td>
			 			<input type="submit" value="SUBMIT">
			 		</td>
			 	</tr>
			 </table>
		</form>
		
	
		
	</div>
</body>
</html>