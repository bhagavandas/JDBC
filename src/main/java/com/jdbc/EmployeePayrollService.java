package com.jdbc;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class EmployeePayrollService {
	public static int id;
	public static String name;
	public static String gender;
	public static double salary;
	public static Date start_date;

	static String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	static String username = "root";
	static String password = "root";
	static Connection con;
	static int rs;
	static String query;

	public static void main(String[] args) {
		// getConnection();
		// readData(name);
		// getEmployeePayrollDataUsingDB("Select * from employee_payroll; ");
		// updateEmployeeSalary(name, salary);
		// PrepareStatementForEmployeeData();
		// RetrieveEmployeePayrollDataByName(name);
		// RetrieveEmployeePayrollDataByName(start_date);
		 //analyseEmployee();
		addNewEmployee(name);

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
				employeePayrollList.add(new EmployeePayrollData(id, name, salary, start_date));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	public static List<EmployeePayrollData> getEmployeePayrollDataUsingDB(String sql) {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		// sql = "Select * from employee_payroll; ";
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
			// employeePayrollList = getEmployeePayrollData(res);

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
			// ResultSet res = statement.executeQuery("Update employee_payroll set
			// salary=300000 where name='Teressa'");
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

	// UC4
	public static List<EmployeePayrollData> PrepareStatementForEmployeeData() {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement statement = (Statement) connection.createStatement();

			PreparedStatement preparedStatement;
			String query = "Update employee_payroll set salary=? where name= ?";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setFloat(1, 3000000);
			preparedStatement.setString(2, "Rakesh");

			rs = preparedStatement.executeUpdate();

			System.out.println("Data Updated! " + rs);
			System.out.println(employeePayrollList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	// UC 4.1 & UC 5

	public static List<EmployeePayrollData> RetrieveEmployeePayrollDataByName(String name) { // Date date
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement statement = (Statement) connection.createStatement();

			PreparedStatement preparedStatement;
			String query = "Select * from employee_payroll where name=?";
			// String query = "Select * from employee_payroll where start_date between
			// '2020-05-15' and '2022-06-25' ";

			preparedStatement = (PreparedStatement) con.prepareStatement(query);
			EmployeePayrollData employeePayrollData = new EmployeePayrollData(id, name, salary, start_date);

			// preparedStatement.setString(1, name);
			// preparedStatement.setString(1, "2022-05-10");

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {
				id = res.getInt(1);
				name = res.getString(2);
				salary = res.getDouble(4);
				System.out.println("Employee Number: " + id);
				System.out.println("Employee Name: " + name);
				System.out.println("Employee Salary: " + salary);
				// System.out.println("Employee Date: " + start_date);

				employeePayrollList.add(new EmployeePayrollData(id, name, salary, start_date));
			}

			System.out.println("Data Updated! " + res);

			System.out.println(employeePayrollList);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	public boolean checkEmployeePayrollInPreparedStatement(String name) {
		List<EmployeePayrollData> employeePayrollList = this.RetrieveEmployeePayrollDataByName(name);
		// List<EmployeePayrollData> employeePayrollList =
		// this.RetrieveEmployeePayrollDataByName(start_date);
		return true;
	}

	// UC6
	public static List<EmployeePayrollData> analyseEmployee() {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement statement = (Statement) connection.createStatement();
			PreparedStatement preparedStatement;
			// String query = "select sum(salary) from employee_payroll where gender='F'
			// group by gender ";
			// String query1 = "select Avg(salary) from employee_payroll where gender='F'
			// group by gender ";
//			String query2 = "select Min(salary) from employee_payroll where gender='F' group by gender ";
//			String query3 = "select max(salary) from employee_payroll where gender='F' group by gender ";
//			String query4 = "select count(salary) from employee_payroll where gender='F' group by gender ";

//			String query = "select sum(salary) from employee_payroll where gender='M' group by gender ";
//			String query1 = "select Avg(salary) from employee_payroll where gender='M' group by gender ";
			String query2 = "select Min(salary) from employee_payroll where gender='M' group by gender ";
//			String query3 = "select max(salary) from employee_payroll where gender='M' group by gender ";
//			String query4 = "select count(salary) from employee_payroll where gender='M' group by gender ";

			// preparedStatement = (PreparedStatement) con.prepareStatement(query);
			// preparedStatement = (PreparedStatement) con.prepareStatement(query1);
			preparedStatement = (PreparedStatement) con.prepareStatement(query2);
//			preparedStatement = (PreparedStatement) con.prepareStatement(query3);
//			preparedStatement = (PreparedStatement) con.prepareStatement(query4);

			EmployeePayrollData employeePayrollData = new EmployeePayrollData(id, name, salary, start_date);

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {
				// id = res.getInt(1);
				// name = res.getString(2);
				salary = res.getDouble(1);
				// System.out.println("Employee Number: " + id);
				// System.out.println("Employee Name: " + name);
				System.out.println("Employee Salary: " + salary);
				employeePayrollList.add(new EmployeePayrollData(id, name, salary, start_date));
			}
			System.out.println("Data Updated! " + res);
			System.out.println(employeePayrollList);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
	
	//UC7
	public static List<EmployeePayrollData> addNewEmployee(String name) {
		String query = " insert into employee_payroll(name, gender, salary, start_date, phoneNumber, address, Department, BasicPay, Deductions, TaxablePay, IncomeTax, NetPay) values(\"Raj\", \"M\", 75000, \"2022-03-18\", 980000250, \"Delhi\", \"S&M\", 75000, 5000, 2500,2500,70000);";
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement statement = (Statement) connection.createStatement();
			// ResultSet res = statement.executeQuery("Update employee_payroll set
			// salary=300000 where name='Teressa'");
			int rs = statement.executeUpdate(query);
			System.out.println("Data Added! " + rs);
			System.out.println(employeePayrollList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;

	}

}
