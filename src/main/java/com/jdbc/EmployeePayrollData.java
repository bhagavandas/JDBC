package com.jdbc;

import java.sql.Date;

public class EmployeePayrollData {
	
	public int id;
	public String name;
	public String gender;
	public double salary;
	public Date date;
	public long phoneNumber;
	public String address;
	public String department;
	public float basicPay;
	public float deductions;
	public float taxablePay;
	public float incomeTax;
	public float netPay;
	public Object employeeName;
	/**
	 * @param id
	 * @param name
	 * @param gender
	 * @param salary
	 * @param date
	 * @param phoneNumber
	 * @param address
	 * @param department
	 * @param basicPay
	 * @param deductions
	 * @param taxablePay
	 * @param incomeTax
	 * @param netPay
	 */
	public EmployeePayrollData(int id, String name, String gender, double salary, Date date, long phoneNumber,
			String address, String department, float basicPay, float deductions, float taxablePay, float incomeTax,
			float netPay) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.department = department;
		this.basicPay = basicPay;
		this.deductions = deductions;
		this.taxablePay = taxablePay;
		this.incomeTax = incomeTax;
		this.netPay = netPay;
	}
	
	
	
	
	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary
				+ ", date=" + date + ", phoneNumber=" + phoneNumber + ", address=" + address + ", department="
				+ department + ", basicPay=" + basicPay + ", deductions=" + deductions + ", taxablePay=" + taxablePay
				+ ", incomeTax=" + incomeTax + ", netPay=" + netPay + "]";
	}
	
	public EmployeePayrollData(int id, String name, double salary, Date date) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.date = date;
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
