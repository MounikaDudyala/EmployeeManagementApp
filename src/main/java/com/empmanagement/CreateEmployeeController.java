package com.empmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.EmployeeDao;
import com.empmanagement.dao.impl.EmployeeDaoImpl;
import com.empmanagement.domain.Employee;

public class CreateEmployeeController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empId = request.getParameter("empId");
		String managerId = request.getParameter("managerId");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");

		if (first_name.isEmpty() || last_name.isEmpty() || empId.isEmpty() || managerId.isEmpty()) {
			RequestDispatcher req = request.getRequestDispatcher("create.jsp");
			req.forward(request, response);
		} else {
			Employee emp = new Employee(empId, first_name, last_name, managerId);
			EmployeeDao empDao = new EmployeeDaoImpl();
			boolean bool = empDao.createEmployee(emp);
			if (bool) {
				response.sendRedirect("/EmployeeManagement/list");
			} else {

				response.sendRedirect("/EmployeeManagement/create.jsp");

			}

		}
	}
}
