package com.empmanagement.dao;

import com.empmanagement.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee createEmployee(Employee emp);
    Employee fetchEmployee(String empId);
    List<Employee> fetchEmployees();
}
