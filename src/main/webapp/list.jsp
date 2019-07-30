<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.empmanagement.domain.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/EmployeeManagement/create">NEW</a>
<table>
  <tr>
  <th>EmpID</th>
  <th>FirstName</th>
  <th>LastName</th>
  <th>ManagerID</th>
</tr>
 <% ArrayList<Employee> list= (ArrayList<Employee>)request.getAttribute("list"); 
 for(Employee emp:list)
 {%>
 <tr>
     <td><%out.print(emp.getEmployeeId());%></td>
     <td><%out.print(emp.getFirstName());%></td>
     <td><%out.print(emp.getLastName());%></td>
     <td><%out.print(emp.getManagerId());%></td>
     <td>
        <FORM ACTION="/EmployeeManagement/delete" METHOD="GET">
            <INPUT TYPE="HIDDEN" NAME="empId" VALUE=<%=emp.getEmployeeId()%>>
            <INPUT TYPE="SUBMIT" VALUE="Delete">
        </FORM>
     </td>
 </tr>
     <%} %>
 </table>
</body>
</html>