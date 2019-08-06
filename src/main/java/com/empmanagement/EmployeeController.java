package com.empmanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.EmployeeDao;
import com.empmanagement.dao.impl.EmployeeDaoImpl;
import com.empmanagement.domain.Employee;
import com.empmanagement.domain.Error;

public class EmployeeController extends HttpServlet {
	EmployeeDao employeeDao;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processEmployee(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processEmployee(request, response);
	}

	private void processEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/new":
			this.newForm(request, response);
			break;
		case "/create":
			this.createEmployee(request, response);
			break;
		case "/edit":
			this.editEmployee(request, response);
			break;
		case "/update":
			this.updateEmployee(request, response);
			break;
		case "/delete":
			this.deleteEmployee(request, response);
			break;
		case "/list":
			this.fetchEmployees(request, response);
			break;
		default:
			this.fetchEmployees(request, response);

		}
	}

	private void newForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("new.jsp");
		rd.forward(request, response);
	}

	private void createEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String managerId = request.getParameter("managerId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		if (firstName.isEmpty() && lastName.isEmpty() && empId.isEmpty() && managerId.isEmpty()) {
			response.sendRedirect("/EmployeeManagement/new");
		}
		if (firstName.isEmpty() || lastName.isEmpty() || empId.isEmpty() || managerId.isEmpty()) {
			String requested_option = "create";
			request.setAttribute("request", requested_option);
			request.setAttribute("employeeId", empId);
			request.setAttribute("managerId", managerId);
			request.setAttribute("f_name", firstName);
			request.setAttribute("l_name", lastName);
			RequestDispatcher request_dispatcher = request.getRequestDispatcher("create.jsp");
			request_dispatcher.forward(request, response);
		} else {
			Employee emp = new Employee(empId, firstName, lastName, managerId);
			boolean is_created = employeeDao.createEmployee(emp);
			if (is_created) {
				String message="Employee Created Successfully!";
				String success_message="Employee Created Successfully!";
				List<Employee> empList = employeeDao.fetchEmployees();
				request.setAttribute("list", empList);
				request.setAttribute("message", success_message);
				RequestDispatcher req = request.getRequestDispatcher("list.jsp");
				req.forward(request, response);
				
			} else {
				response.sendRedirect("/EmployeeManagement/create");
			}

		}
	}

	private void editEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String Id = request.getParameter("empId");
		Employee employee = employeeDao.fetchEmployee(Id);
		if (employee.getEmployeeId()==null) {
			response.sendRedirect("/EmployeeManagement/new");
		} else {
			String requested_option = "update";
			request.setAttribute("request", requested_option);
			Employee emp = employeeDao.fetchEmployee(Id);
			request.setAttribute("employeeId", emp.getEmployeeId());
			request.setAttribute("managerId", emp.getManagerId());
			request.setAttribute("f_name", emp.getFirstName());
			request.setAttribute("l_name", emp.getLastName());
			RequestDispatcher request_dispatcher = request.getRequestDispatcher("create.jsp");
			request_dispatcher.forward(request, response);
		}
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String managerId = request.getParameter("managerId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		if (firstName.isEmpty() && lastName.isEmpty() && empId.isEmpty() && managerId.isEmpty()) {
			response.sendRedirect("/EmployeeManagement/new");
		}
		if (firstName.isEmpty() || lastName.isEmpty() || empId.isEmpty() || managerId.isEmpty()) {
			String pathRequested = "create";
			request.setAttribute("request", pathRequested);
			request.setAttribute("employeeId", empId);
			request.setAttribute("managerId", managerId);
			request.setAttribute("f_name", firstName);
			request.setAttribute("l_name", lastName);
			String requested_option = "update";
			request.setAttribute("request", requested_option);
			RequestDispatcher request_dispatcher = request.getRequestDispatcher("create.jsp");
			request_dispatcher.forward(request, response);
		} else {
			Employee emp = new Employee(empId, firstName, lastName, managerId);
			boolean is_updated = employeeDao.updateEmployee(emp);
			if (is_updated) {
				String success_message="Employee Updated Successfully!";
				List<Employee> empList = employeeDao.fetchEmployees();
				request.setAttribute("list", empList);
				request.setAttribute("message", success_message);
				RequestDispatcher req = request.getRequestDispatcher("list.jsp");
				req.forward(request, response);
				
			} else {
				Error error = new Error();
				error.set_message("Employee not Updated");
				request.setAttribute("error", error.get_message());
				RequestDispatcher request_dispatcher = request.getRequestDispatcher("error.jsp");
				request_dispatcher.forward(request, response);
			}
		}
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String Id = request.getParameter("empId");
		if (Id==null) {
			Error error = new Error();
			error.set_message("Wrong Request with EmpId as null");
			request.setAttribute("error", error.get_message());
			RequestDispatcher request_dispatcher = request.getRequestDispatcher("error.jsp");
			request_dispatcher.forward(request, response);

		} else {
			boolean is_deleted = employeeDao.deleteEmployee(Id);
			if (is_deleted) {
				String success_message="Employee deleted Successfully!";
				List<Employee> empList = employeeDao.fetchEmployees();
				request.setAttribute("list", empList);
				request.setAttribute("message", success_message);
				RequestDispatcher req = request.getRequestDispatcher("list.jsp");
				req.forward(request, response);
			} else {
				Error error = new Error();
				error.set_message("Employee not existed");
				request.setAttribute("error", error.get_message());
				RequestDispatcher request_dispatcher = request.getRequestDispatcher("error.jsp");
				request_dispatcher.forward(request, response);

			}
		}
	}

	private void fetchEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> empList = employeeDao.fetchEmployees();
		request.setAttribute("list", empList);
		RequestDispatcher req = request.getRequestDispatcher("list.jsp");
		req.forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDaoImpl();
	}
}
