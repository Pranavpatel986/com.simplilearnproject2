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
				<a href="ClassRoom?class_action=list">List All Classes</a>
		</div>
	</div>
	
	

	<div class="container">
		<h1>ClassRoom</h1>
		<form action="ClassRoom" method="post">
			<table>
				<tr>
					<td>id:</td>
					<td><input type="text" name="id" placeholder="id"></td>
				</tr>
				<tr>
					<td><input type="hidden"  name="class_action" value="one"></td>
					<td><input type="submit" value="SUBMIT"></td>
				</tr>
			</table>
		</form>
		
	</div>
	
		<div class="container">

		<h1>Add new Class</h1>
		<form action="ClassRoom" method="post">
			 <table> 
			 	<tr>
			 		<th>ID</th>
			 		<td><input type="text" name="class_id"></td>
			 	</tr>
			 	<tr>
			 		<th>Name</th>
			 		<td><input type="text" name="class_name"></td>
			 	</tr>
			 	<tr>
			 		<th>Capacity</th>
			 		<td><input type="text" name="class_capacity"></td>
			 	</tr>
			 	<tr>
			 		<th><input type="hidden" name="class_action" value="new"></th>
			 		<td>
			 			<input type="submit" value="SUBMIT">
			 		</td>
			 	</tr>
			 </table>
		</form>
		
	
		
	</div>
</body>
</html>