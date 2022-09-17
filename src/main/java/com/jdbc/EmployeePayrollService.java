package com.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class EmployeePayrollService {
	public static int id;
	public static String name;
	public static String gender;
	public static double salary;

	static String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	static String username = "root";
	static String password = "root";
	static Connection con;

	public static void main(String[] args) {
		//getConnection();
		//readData(name);
		getEmployeePayrollDataUsingDB("Select * from employee_payroll; ");
		//updateEmployeeSalary(name, salary);
	}

	public static Connection getConnection() {
		try {
			System.out.println("Connecting to database " + jdbcURL);
			con = (Connection) DriverManager.getConnection(jdbcURL, username, password);

			System.out.println("Connection is successful!!!" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static List<EmployeePayrollData> readData(String name) {
		String sql = "Select * from employee_payroll; ";
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement statement = (Statement) connection.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				id = res.getInt(1);
				name = res.getString(2);
				salary = res.getDouble(4);
				System.out.println("Employee Number: " + id);
				System.out.println("Employee Name: " + name);
				System.out.println("Employee Salary: " + salary);
				employeePayrollList.add(new EmployeePayrollData(id, name, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	public static List<EmployeePayrollData> getEmployeePayrollDataUsingDB(String sql) {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		//sql = "Select * from employee_payroll; ";
		// if(this.getEmployeePayrollDataStatement(null))
		// EmployeePayrollData employeePayrollData = new EmployeePayrollData();
		try (Connection connection = getConnection()) {
			Statement statement = (Statement) connection.createStatement();
			ResultSet res = statement.executeQuery(sql);
			employeePayrollList = getEmployeePayrollData(res);
			System.out.println(employeePayrollList);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return employeePayrollList;

	}

	public static List<EmployeePayrollData> getEmployeePayrollData(ResultSet res) {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try (Connection connection = getConnection()) {
			Statement statement = (Statement) connection.createStatement();
			// ResultSet res1 = statement.executeQuery(sql);
			//employeePayrollList = getEmployeePayrollData(res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	public static List<EmployeePayrollData> updateEmployeeSalary(String name, double salary) {
		String query = "Update employee_payroll set salary=3000000 where name='Teressa'";
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement statement = (Statement) connection.createStatement();
			//ResultSet res = statement.executeQuery("Update employee_payroll set salary=300000 where name='Teressa'");
			int rs = statement.executeUpdate("Update employee_payroll set salary=3000000 where name='Teressa'");
			System.out.println("Data Updated" + rs);
			System.out.println(employeePayrollList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
		
	}

	public boolean checkEmployeePayrollInSynWithDB(String name, double salary) {
		List<EmployeePayrollData> employeePayrollList = this.getEmployeePayrollData(null);
		return true;
	}
	
	

//	public void updateEmployeeSalary(String name, double salary) {
//		int result = 
//		
//	}

}
