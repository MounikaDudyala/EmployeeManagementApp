package Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.empmanagement.Employee;

import dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/database2";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public boolean createEmployee(Employee emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into Employee values(?,?,?,?)");
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getManagerId());
			int i = pstmt.executeUpdate();
			if (i == 1)
				return true;
			if (i == 0)
				return false;
		} catch (SQLException e) {
			System.out.println("message");
		} catch (Exception e) {

			System.out.println("message");
		}
		return false;
	}

	public Employee fetchEmployee(String empId) {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from Employee where empId=?");
			pstmt.setString(1, empId);
			ResultSet rs = pstmt.executeQuery();
			Employee emp = new Employee();
			while (rs.next()) {
				emp.setEmployeeId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setManagerId(rs.getString(4));
			}

			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> fetchEmployees() {
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			String query = "select * from Employee";
			ResultSet rs = st.executeQuery(query);
			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setManagerId(rs.getString(4));
				list.add(emp);

			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
