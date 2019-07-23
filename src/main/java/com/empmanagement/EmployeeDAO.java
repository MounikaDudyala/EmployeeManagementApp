package com.empmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EmployeeDAO {

	String url = "jdbc:mysql://localhost:3306/database2";
	String user = "root";
	String password = "root";

	public void createEmployee(Employee emp) {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement("insert into Employee values(?,?,?,?)");
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getManagerId());
			pstmt.executeUpdate();
			System.out.println("Employee Created");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public ResultSet fetchEmployee(String empId)
	{ 
		try {
		Connection conn = DriverManager.getConnection(url, user, password);
			  PreparedStatement pstmt =conn.prepareStatement("select * from Employee where empId=?");
			  pstmt.setString(1, empId);
			  ResultSet rs=pstmt.executeQuery();
			  return rs;
			 
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	} 
		return null;
	}
	public ResultSet fetchEmployees()
	{
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();
			String query="select * from Employee";
			ResultSet rs=st.executeQuery(query);
			return rs;
			
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
