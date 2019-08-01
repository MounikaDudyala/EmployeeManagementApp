<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
	 <%@ page import="java.lang.String" %>
	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  
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
<%String Id= request.getParameter("empId");%> 
<%if(Id!=null){ %>
	<form action="edit" method="post">
		<%EmployeeDao empDao=new EmployeeDaoImpl();
     Employee emp=empDao.fetchEmployee(Id);%>
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
<%} %>
	<% if(Id==null)
		{%>
	<form action="create" method="post">
		<table style="width: 50%">
			<tr>
				<td>EmpId</td>
				<td><input type="text" name="empId" required pattern="[1-9][a-zA-Z0-9]{1,4}"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" required pattern="[a-zA-Z]{1,15}" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"  required pattern="[a-zA-Z]{1,15}"/></td>
			</tr>
			<tr>
				<td>ManagerId</td>
				<td><input type="text" name="managerId" required pattern="[a-zA-Z0-9]{1,5}" /></td>
			</tr>
		</table>
		<input type="submit" value="Create" />
</form>
<%} %>
</body>
</body>
</body>
</html>