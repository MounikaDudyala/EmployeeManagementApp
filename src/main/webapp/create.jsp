<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page import="java.lang.String"%>
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
	<%
		String requestedOption = (String) request.getAttribute("request");
	%>
	<!--requestedOption can be either "create" or "update"-->
	<form action="<%=requestedOption %>" method="post">
		<table style="width: 50%">
			<tr>
				<td>EmpId*</td>
				<td><input type="text" name="empId" required
					pattern="[1-9][a-zA-Z0-9]{1,4}"
					value=<%=request.getAttribute("employeeId")%> /></td>
			</tr>
			<tr>
				<td>First Name*</td>
				<td><input type="text" name="firstName" required
					pattern="[a-zA-Z]{1,15}" value=<%=request.getAttribute("f_name")%> /></td>
			</tr>
			<tr>
				<td>Last Name*</td>
				<td><input type="text" name="lastName" required
					pattern="[a-zA-Z]{1,15}" value=<%=request.getAttribute("l_name")%> /></td>
			</tr>
			<tr>
				<td>ManagerId*</td>
				<td><input type="text" name="managerId" required
					pattern="[a-zA-Z0-9]{1,5}"
					value=<%=request.getAttribute("managerId")%> /></td>
			</tr>
			<tr>
				<td><input type="submit" value="<%=requestedOption %>" /></td>
			</tr>
		</table>
	</form>
	<form action="list" method="Get">
	 <input type="submit" value="Cancel"/>
	</form>
</body>
</html>