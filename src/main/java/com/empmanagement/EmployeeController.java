package com.empmanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.EmployeeDao;
import com.empmanagement.dao.impl.EmployeeDaoImpl;
import com.empmanagement.domain.Employee;

public class EmployeeController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String list = "/list";
		String create = "/new";
		String delete = "/delete";
		String path = request.getServletPath();

		if (path.contentEquals(create)) {
			newForm(request, response);
		}
		if (path.equals(list)) {
			fetchEmployee(request, response);
		} else if (path.contentEquals(delete)) {
			deleteEmployee(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String createEmployee = "/create";
		String editEmployee="/edit";
		String path = request.getServletPath();
		if (path.contentEquals(createEmployee)) {
			createEmployee(request, response);
		}
		if(path.contentEquals(editEmployee))
		{
			editEmployee(request,response);
		}
	}

	public void fetchEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao empDao = new EmployeeDaoImpl();
		List<Employee> empList = empDao.fetchEmployees();
		request.setAttribute("list", empList);
		RequestDispatcher req = request.getRequestDispatcher("list.jsp");
		req.forward(request, response);
	}

	public void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
		rd.forward(request, response);
	}

	public void createEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String managerId = request.getParameter("managerId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		if (firstName.isEmpty() || lastName.isEmpty() || empId.isEmpty() || managerId.isEmpty()) {
			RequestDispatcher req = request.getRequestDispatcher("create.jsp");
			req.forward(request, response);
		} else {
			Employee emp = new Employee(empId, firstName, lastName, managerId);
			EmployeeDao empDao = new EmployeeDaoImpl();
			boolean bool = empDao.createEmployee(emp);
			if (bool) {
				response.sendRedirect("/EmployeeManagement/list");
			} else {
				response.sendRedirect("/EmployeeManagement/create");
			}

		}
	}

	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String Id = request.getParameter("empId");
		if (Id == null)
			System.out.println("employee not found");
		EmployeeDao empDao = new EmployeeDaoImpl();
		boolean bool = empDao.deleteEmployee(Id);
		if (bool) {
			response.sendRedirect("/EmployeeManagement/list");
			System.out.println("Employee deleted:" + Id);
		} else
			System.out.println("Employee is not deleted");

	}
	public void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String empId = request.getParameter("empId");
		String managerId = request.getParameter("managerId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		if (firstName.isEmpty() || lastName.isEmpty() || empId.isEmpty() || managerId.isEmpty()) {
			RequestDispatcher req = request.getRequestDispatcher("create.jsp");
			req.forward(request, response);
		}
			else {
				Employee emp = new Employee(empId, firstName, lastName, managerId);
			EmployeeDao empDao = new EmployeeDaoImpl();
			boolean bool = empDao.editEmployee(emp);
			if (bool) {
				response.sendRedirect("/EmployeeManagement/list");
			} else {
				response.sendRedirect("/EmployeeManagement/new");
			}	
	}
		}
}

