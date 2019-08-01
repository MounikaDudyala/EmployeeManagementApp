package com.empmanagement.dao;

import com.empmanagement.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    boolean createEmployee(Employee emp);
    Employee fetchEmployee(String empId);
    List<Employee> fetchEmployees();
	boolean deleteEmployee(String empId);
	boolean editEmployee(Employee emp);
}
