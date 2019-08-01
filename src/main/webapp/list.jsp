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
<a href="/EmployeeManagement/new">NEW</a>
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
     <a href="/EmployeeManagement/delete?empId=<%=emp.getEmployeeId()%>">delete</a>
     </td>
     <td>
     <a href="create.jsp?empId=<%=emp.getEmployeeId()%>">edit</a>       
      </td>
 </tr>
     <%} %>
 </table>
</body>
</html>