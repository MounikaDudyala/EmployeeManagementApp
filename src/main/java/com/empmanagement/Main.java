package com.empmanagement;

import com.empmanagement.dao.EmployeeDao;
import com.empmanagement.dao.impl.EmployeeDaoImpl;
import com.empmanagement.domain.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static EmployeeDao empDAO = new EmployeeDaoImpl();

	public static void main(String args[]) {
		System.out.println("1.CreateEmployee\t2.FetchEmployee\t3.FetchEmployees");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:createEmployee();
		  break;
		case 2:fetchEmployee();
		break;
		case 3:fetchEmployees();
		}
	}

	public static void createEmployee() {
		System.out.println("Enter EmployeeId,FirstName,LastName,ManagerId");
		String empId = sc.next();
		String firstName = sc.next();
		String lastName = sc.next();
		String managerId = sc.next();
		Employee emp = new Employee(empId, firstName, lastName, managerId);
		empDAO.createEmployee(emp);
	}

	public static void fetchEmployee() {
		System.out.println("Enter EmployeeId");
		String empId = sc.next();
		ResultSet rs = empDAO.fetchEmployee(empId);
		try {
			while (rs.next()) {
				System.out.println("empId:" + rs.getString(1) + " FirstName:" + rs.getString(2) + " LastName:"
						+ rs.getString(3) + " ManagerId:" + rs.getString(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void fetchEmployees() {

		ResultSet rs = empDAO.fetchEmployees();
		try {
			while (rs.next())
				System.out.println("empId:" + rs.getString(1) + " FirstName:" + rs.getString(2) + " LastName:"
						+ rs.getString(3) + " ManagerId:" + rs.getString(4));

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
