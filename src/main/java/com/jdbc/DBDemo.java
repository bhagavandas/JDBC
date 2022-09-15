package com.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import com.mysql.jdbc.Connection;

public class DBDemo {
	
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String username = "root";
		String password = "root";
		Connection con;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath", e);
		}
		
		listDrivers();
		
		try {
			System.out.println("Connecting to database " + jdbcURL);
			con = (Connection) DriverManager.getConnection(jdbcURL, username, password);
			
			System.out.println("Connection is successful!!!" + con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = (Driver)driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}

}
