package com.empmanagement;

public class Employee {
    
	private String empId;
	private String firstName;
	private String lastName;
	private String managerId;
	public Employee()
	{
		
	}
	public Employee(String empId,String firstName,String lastName,String managerId)
	{
		this.empId=empId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.managerId=managerId;
	}
	public String getEmployeeId()
	{
		return empId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getManagerId()
	{
		return managerId;
	}
	public String toString()
	{
		return "Id:"+empId+"FirstName:"+"firstName"+"LastName:"+lastName;
	}
}
