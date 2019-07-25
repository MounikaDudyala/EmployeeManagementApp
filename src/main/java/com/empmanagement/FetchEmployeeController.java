package com.empmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.EmployeeDao;
import com.empmanagement.dao.impl.EmployeeDaoImpl;
import com.empmanagement.domain.Employee;

public class FetchEmployeeController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
    	 EmployeeDao empDao=new EmployeeDaoImpl();
 		List<Employee> empList=empDao.fetchEmployees();
 		request.setAttribute("list", empList);
 		 RequestDispatcher req = request.getRequestDispatcher("list.jsp");
			req.forward(request, response);
    	 
	} 
     
}
