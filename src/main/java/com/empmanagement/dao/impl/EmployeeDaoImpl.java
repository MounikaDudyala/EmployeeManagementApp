package com.empmanagement.dao.impl;

import com.empmanagement.dao.AbstractDBConnection;
import com.empmanagement.dao.EmployeeDao;
import com.empmanagement.domain.Employee;

import java.sql.*;
import java.util.List;

public class EmployeeDaoImpl extends AbstractDBConnection implements EmployeeDao {

    public Employee createEmployee(Employee emp) {
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into Employee values(?,?,?,?)");
            pstmt.setString(1, emp.getEmployeeId());
            pstmt.setString(2, emp.getFirstName());
            pstmt.setString(3, emp.getLastName());
            pstmt.setString(4, emp.getManagerId());
            int id = pstmt.executeUpdate();
            System.out.println("Employee Created");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    public Employee fetchEmployee(String empId) {
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from Employee where empId=?");
            pstmt.setString(1, empId);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> fetchEmployees() {
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "select * from Employee";
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
