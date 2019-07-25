package dao;

import java.util.List;

import com.empmanagement.Employee;

public interface EmployeeDao {

	public boolean createEmployee(Employee emp);
	public Employee fetchEmployee(String empId);
	public List<Employee> fetchEmployees();
}
