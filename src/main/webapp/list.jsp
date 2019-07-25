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
<table>
  <% ArrayList<Employee> list= (ArrayList<Employee>)request.getAttribute("list"); 
      for(Employee emp:list)
      {
    	    out.print("<br/>"+emp.getEmployeeId()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getManagerId());
    	    
      } 
      
  %>
  </table>
  <br>
 <a href="create.jsp">NEW</a>
 
</body>
</html>