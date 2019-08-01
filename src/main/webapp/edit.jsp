<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.empmanagement.dao.EmployeeDao"%>
<%@ page import="com.empmanagement.dao.impl.EmployeeDaoImpl"%>
<%@ page import="com.empmanagement.domain.Employee"%>
<%@ page import="java.lang.String"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="edit" method="post">
		<%EmployeeDao empDao=new EmployeeDaoImpl();
String empId=(String)request.getParameter("empId");
     Employee emp=empDao.fetchEmployee(empId);%>
		<table style="with: 50%">
			<tr>
				<td>EmpId</td>
				<td><input type="text" name="empId" value="<%=emp.getEmployeeId()%>" readonly/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" required pattern="[a-zA-Z]{1,15}"
					value="<%=emp.getFirstName()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" required pattern="[a-zA-Z]{1,15}"
					value="<%=emp.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>ManagerId</td>
				<td><input type="text" name="managerId" value="<%=emp.getManagerId()%>"  required pattern="[a-zA-Z0-9]{1,5}"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>