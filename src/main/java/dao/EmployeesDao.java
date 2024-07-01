package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.EmployeesDto;

public class EmployeesDao {
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "hr";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	public ArrayList<EmployeesDto> showEmployees() throws Exception {
		ArrayList<EmployeesDto> dbList = new ArrayList<EmployeesDto>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM employees";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int employeeId = rs.getInt("employee_id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			String phoneNumber = rs.getString("phone_number");
			String hireDate = rs.getString("hire_date");
			String jobId = rs.getString("job_id");
			int salary = rs.getInt("salary");
			double commissionPct = rs.getDouble("commission_pct");
			int managerId = rs.getInt("manager_id");
			int departmentId = rs.getInt("department_id");
			
			EmployeesDto obj = new EmployeesDto(employeeId, firstName, lastName, email,
												phoneNumber,hireDate, jobId, salary,
												commissionPct, managerId, departmentId);
			dbList.add(obj);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return dbList;
 	}
}
