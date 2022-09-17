package com.jdbc;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class EmployeePayroll {

	public static void main(String[] args) {
		getConnection();
	
	}
		
		public static boolean getConnection() {

		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "root";
		String password = "root";
		Connection con;
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

		try {
			System.out.println("Connecting to database " + jdbcURL);
			con = (Connection) DriverManager.getConnection(jdbcURL, username, password);

			System.out.println("Connection is successful!!!" + con);

			int id;
			String name;
			String gender;
			double salary;
			Date date;
			long phoneNumber;
			String address;
			String department;
			float basicPay;
			float deductions;
			float taxablePay;
			float incomeTax = 0;
			float netPay;
			Statement statement;
			ResultSet res;
			int rs;
			
			statement = (Statement) con.createStatement();
			res = statement.executeQuery("Select * from employee_payroll");
			//res = statement.executeQuery("Select * from employee_payroll");
			//rs = statement.executeUpdate("Update employee_payroll set salary=300000 where name='Teressa'");
			System.out.println("Data Updated" + res);
			//System.out.println("Data Updated" + rs);
			while(res.next()) {
				id = res.getInt(1);
				name = res.getString(2);
				gender = res.getString(3);
				salary = res.getDouble(4);
				date = res.getDate(5);
				phoneNumber = res.getLong(6);
				address = res.getString(7);
				department = res.getString(8);
				basicPay = res.getFloat(9);
				deductions = res.getFloat(10);
				taxablePay = res.getFloat(11);
				netPay = res.getFloat(12);
				System.out.println("Employee Number: " + id);
				System.out.println("Employee Name: " + name);
				System.out.println("Employee gender: " + gender);
				System.out.println("Employee salary: " + salary);
				System.out.println("Employee Start date: " + date);
				System.out.println("Employee PhoneNumber: " + phoneNumber);
				System.out.println("Employee Address: " + address);
				System.out.println("Employee Department: " + department);
				System.out.println("Employee Basic Pay: " + basicPay);
				System.out.println("Employee Deductions: " + deductions);
				System.out.println("Employee Taxable Pay: " + taxablePay);
//				System.out.println("Employee NetPay: " + netPay);
//				employeePayrollList.add(new EmployeePayrollData(id, name, gender, salary, date, phoneNumber, address, department, basicPay, deductions, taxablePay, incomeTax, netPay));
			}
			
			System.out.println(employeePayrollList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
}