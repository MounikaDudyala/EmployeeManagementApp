package com.empmanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impl.EmployeeDaoImpl;

public class EmployeeController extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{     EmployeeDaoImpl empDaoImpl=new EmployeeDaoImpl();
	         List<Employee> list=empDaoImpl.fetchEmployees();
	     request.setAttribute("list", list);
		  RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
		  rd.forward(request, response);
	}
}
