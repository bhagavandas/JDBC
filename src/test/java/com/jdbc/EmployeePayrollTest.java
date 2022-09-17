package com.jdbc;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class EmployeePayrollTest {

	@Test
	public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeePayrollData> res = employeePayrollService.readData("Teressa");
		employeePayrollService.updateEmployeeSalary("Teressa", 3000000);
		boolean result = employeePayrollService.checkEmployeePayrollInSynWithDB("Teressa", 3000000);
		Assert.assertTrue(result);

	}
	
	//UC 4
	@Test
	public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDBWithPreparedStatement() {
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, "Anirban", 3000000, null);
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		
		List<EmployeePayrollData> result2 = employeePayrollService.RetrieveEmployeePayrollDataByName(employeePayrollData.getName());
		

		System.out.println(employeePayrollData.getName());
		Assert.assertEquals(employeePayrollData.getName(), "Anirban");
		
}
	
	
}