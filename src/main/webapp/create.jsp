<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="createEmployee" method="post">
			<table style="with: 50%">
				<tr>
					<td>EmpId</td>
					<td><input type="text" name="empId" /></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
					<tr>
					<td>ManagerId</td>
					<td><input type="text" name="managerId" /></td>
				</tr>
				</table>
			<input type="submit" value="Create" /></form>
</body>
</body>
</html>