package com.empmanagement;
import java.util.List;
import java.util.Scanner;

import Impl.EmployeeDaoImpl;
import dao.EmployeeDao;

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
		boolean response=empDAO.createEmployee(emp);
		if(response)
			System.out.println("Employee created");
		else
			System.out.println("Employee is not created");
	}

	public static void fetchEmployee() {
		System.out.println("Enter EmployeeId");
		String empId = sc.next();
		Employee emp = empDAO.fetchEmployee(empId);
		System.out.println(emp);

	}

	public static void fetchEmployees() {

		List<Employee> list = empDAO.fetchEmployees();
		for(Employee emp:list)
		{
			System.out.println(emp);
		}
	}
}
